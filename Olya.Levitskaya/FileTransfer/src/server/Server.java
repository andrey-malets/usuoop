package server;

public class Server {

	public static void main(String[] args) {
		ArgumentParser parser = new ArgumentParser();
		parser.parse(args);
		if (new FileReceiver(parser, new SocketNetworkCommunicator()).ReceiveFile())
			System.out.println("Файл принят успешно.");
		else
			System.out.println("Файл не получилось принять.");
	}

}
