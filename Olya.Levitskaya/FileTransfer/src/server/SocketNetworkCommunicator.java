package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketNetworkCommunicator implements INetworkCommunicator{
	private Socket clientSocket;
	
	public Boolean Configure(Integer port) {
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
		} catch (Exception e) {
			return false;
		}
		
		try {
			clientSocket = serverSocket.accept();
		} catch (IOException e) {
			return false;
		}
		
		return true;
	}
	
	public ReceiveResult Receive(byte[] outData){
		int bytesRead;
		try {
			bytesRead = clientSocket.getInputStream().read(outData);
		} catch (IOException e) {
			return new ReceiveResult(false, -1);
		}
		return new ReceiveResult(true, bytesRead);
	}
}
