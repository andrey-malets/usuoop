package client;

public class Client {

	public static void main(String[] args) {
		ArgumentParser parser = new ArgumentParser();
		parser.parse(args);
		if (new FileSender(parser, new SocketNetworkCommunicator()).SendFile())
			System.out.println("Send success.");
		else
			System.out.println("Send failed.");
	}
}
