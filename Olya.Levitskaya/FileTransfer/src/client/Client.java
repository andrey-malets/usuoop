package client;

public class Client {

	public static void main(String[] args) {
		ArgumentParser parser = new ArgumentParser();
		if(!parser.parse(args)){
			System.out.println("Error in Arguments");
			return;
		}
		if (new FileSender(parser, new SocketNetworkCommunicator()).SendFile())
			System.out.println("Send success.");
		else
			System.out.println("Send failed.");
	}
}
