package server;

public class Server {

	public static void main(String[] args) {
		ArgumentParser parser = new ArgumentParser();
		if(!parser.parse(args)){
			System.out.println("Error in Arguments");
			return;
		}
		if (new FileReceiver(parser, new SocketNetworkCommunicator()).ReceiveFile())
			System.out.println("Receive success.");
		else
			System.out.println("Receive failed.");
	}

}
