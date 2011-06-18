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
	private ArgumentParser parser;

	public EncodingConvertor(ArgumentParser parser){
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
			return false;
		}
		Writer osw;
		try {
			osw = new OutputStreamWriter(fos, parser.getDestinationEncoding());
		} catch (UnsupportedEncodingException e) {
			return false;
		}
		char[] buffer = new char[1024];
		int bytesRead = 0;
		while(true){
			try {
				bytesRead = isr.read(buffer);
			} catch (IOException e) {
				return false;
			}
			
			if (bytesRead < 0)
				break;
			
			try {
				osw.write(buffer);
			} catch (IOException e) {
				return false;
			}
		}
		
		try {
			osw.close();
		} catch (IOException e) {
			return false;
			
		}
		try {
			isr.close();
		} catch (IOException e) {
			return false;
		}
		
		return true;
	}
}
