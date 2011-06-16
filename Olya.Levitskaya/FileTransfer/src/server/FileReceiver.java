package server;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileReceiver {
	private ArgumentParser argumentParser;
	private INetworkCommunicator networkCommunicator;
	
	public FileReceiver(ArgumentParser argumentParser, INetworkCommunicator networkCommunicator){
		this.argumentParser = argumentParser;
		this.networkCommunicator = networkCommunicator;
	}

	public Boolean ReceiveFile(){
		if (!networkCommunicator.Configure(argumentParser.getPort()))
			return false;

		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(argumentParser.getOutputFile());
		} catch (FileNotFoundException e) {
			return false;
		}
		
		byte[] buffer = new byte[1024];
		int bytesRead = 0;
		
		while(true){
			if (!networkCommunicator.Receive(buffer, bytesRead))
				return false;
			
			if (bytesRead <= 0)
				break;
			
			byte[] bytesReceived = new byte[bytesRead];
			for (int i = 0; i < bytesRead; i++)
				bytesReceived[i] = buffer[i];
			
			try {
				fos.write(bytesReceived);
			} catch (IOException e) {
				return false;
			}
		}
		
		try {
			fos.close();
		} catch (IOException e) {
			return false;
		}
		
		return true;
	}
}
