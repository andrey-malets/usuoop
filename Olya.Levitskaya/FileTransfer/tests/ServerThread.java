import server.Server;

public class ServerThread extends Thread{	
	public void run() {
		Server.main(new String[]{"3333", "output.txt"}); 
	}
}
