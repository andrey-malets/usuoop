package client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileSender {
	private ArgumentParser argumentParser;
	private INetworkCommunicator networkCommunicator;
	
	public FileSender(ArgumentParser argumentParser, INetworkCommunicator networkCommunicator){
		this.argumentParser = argumentParser;
		this.networkCommunicator = networkCommunicator;
	}
	
	public Boolean SendFile(){
		if (!networkCommunicator.Configure(argumentParser.getIPAddress(), argumentParser.getPort()))
			return false;
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(argumentParser.getFile());
		} catch (FileNotFoundException e) {
			return false;
		}
		
		byte[] buffer = new byte[1024];
		int bytesRead;
		
		while(true){
			try {
				bytesRead = fis.read(buffer);
			} catch (IOException e) {
				return false;
			}
			
			if (bytesRead <= 0)
				break;
			
			byte[] bytesToSend = new byte[bytesRead];
			for (int i = 0; i < bytesRead; i++)
				bytesToSend[i] = buffer[i];
			
			if (!networkCommunicator.Send(bytesToSend))
				return false;
		}
		
		try {
			fis.close();
		} catch (IOException e) {
			return false;
		}
		
		return true;
	}
}
