package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketNetworkCommunicator implements INetworkCommunicator{
	private ServerSocket serverSocket;
	private Socket clientSocket;
	
	public Boolean Configure(Integer port) {
		try {
			serverSocket = new ServerSocket(port);
		} catch (Exception e) {
			System.out.println("create server socket");
			return false;
		}
		
		try {
			clientSocket = serverSocket.accept();
		} catch (IOException e) {
			System.out.println("create client socket");
			return false;
		}
		
		return true;
	}
	
	public ReceiveResult Receive(byte[] outData){
		if (clientSocket.isClosed()){
			return new ReceiveResult(false, -1);
		}
		
		int bytesRead = 0;
		try {
			bytesRead = clientSocket.getInputStream().read(outData);
		} catch (IOException e) {
			System.out.println(e);
			//if (e.getMessage() != "Socket is closed")
				return new ReceiveResult(false, -1);
		}
				
		return new ReceiveResult(true, bytesRead);
	}
	
	public Boolean End(){
		try {
			clientSocket.close();
		} catch (IOException e) {
			return false;
		}
		
		try {
			serverSocket.close();
		} catch (IOException e) {
			return false;
		}
		
		return true;
	}
}
