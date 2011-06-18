package client;

import java.io.IOException;
import java.net.Socket;

public class SocketNetworkCommunicator implements INetworkCommunicator{
	private Socket socket;
	
	public Boolean Configure(String IPAddress, Integer port) {
		try {
			socket = new Socket(IPAddress, port);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public Boolean Send(byte[] data){
		try {
			socket.getOutputStream().write(data);
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	public Boolean End(){
		try {
			socket.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
}
