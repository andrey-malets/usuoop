package general;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class EncodingConvertor {
	private IArgumentParser parser;

	public EncodingConvertor(IArgumentParser parser){
		this.parser = parser;
	}
	
	public Boolean convert(){
		FileInputStream fis;
		try {
			fis = new FileInputStream(parser.getSourceFile());
		} catch (FileNotFoundException e) {
			return false;
		}
		InputStreamReader isr = null;
		try {
			isr = new InputStreamReader(fis, parser.getSourceEncoding());
		} catch (UnsupportedEncodingException e) {
			return false;
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(parser.getDestinationFile());
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Writer osw;
		try {
			osw = new OutputStreamWriter(fos, parser.getDestinationEncoding());
		} catch (UnsupportedEncodingException e) {
			return false;
		}
		int bytesRead = 0;
		Thread thread = new WriterThread(osw);
		thread.start();
		
		while(true){
			synchronized (ConverterData.bufferLock) {
				if (!ConverterData.hasData){
					try {
						bytesRead = isr.read(ConverterData.buffer);
						ConverterData.hasData = true;
					} catch (IOException e) {
						thread.stop();
						return false;
					}
				}
			}
			
			if (bytesRead < 0)
				break;
			
			if (!thread.isAlive()) 
				return false;
		};
		
		thread.stop();
		
		try {
			osw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			isr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
}
