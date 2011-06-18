import client.Client;

public class ClientThread extends Thread{
	private Integer port;
	
	public ClientThread(int port){
		this.port = port; 
	}
	
	public void run() {
		Client.main(new String[]{"127.0.0.1", port.toString(), "input.txt"});
	}
}
