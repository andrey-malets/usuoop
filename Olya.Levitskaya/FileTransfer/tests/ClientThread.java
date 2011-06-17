import client.Client;

public class ClientThread extends Thread{	
	public void run() {
		Client.main(new String[]{"127.0.0.1", "3333", "input.txt"});
	}
}
