import server.Server;

public class ServerThread extends Thread{
	private Integer port;
	
	public ServerThread(int port){
		this.port = port;
	}
	
	public void run() {
		Server.main(new String[]{port.toString(), "output.txt"}); 
	}
}
