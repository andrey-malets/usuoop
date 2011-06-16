package client;

public class Client {

	public static void main(String[] args) {
		ArgumentParser parser = new ArgumentParser();
		parser.parse(args);
		if (new FileSender(parser, new SocketNetworkCommunicator()).SendFile()){
			System.out.println("Файл передан успешно.");
		}
		else
			System.out.println("Файл не получилось передать.");
	}
}
