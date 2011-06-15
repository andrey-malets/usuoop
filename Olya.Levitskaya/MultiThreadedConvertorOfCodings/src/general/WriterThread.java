package general;

import java.io.IOException;
import java.io.Writer;

public class WriterThread extends Thread{
	private Writer osw;
	
	public WriterThread(Writer _osw){
		this.osw = _osw;
	}
	
	public void run() {
		System.out.println("This is another Thread started!"); 
		while(true){
			synchronized (ConverterData.bufferLock) {
				if (ConverterData.hasData){
					try {
						osw.write(ConverterData.buffer);
						ConverterData.hasData = false;
					} catch (IOException e) {
						return;
					}
				}
			}
		}
    }
	
}
