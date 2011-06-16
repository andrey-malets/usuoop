package client;

public class ArgumentParser{
	private String IPAddress;
	private Integer port;
	private String file;
	
	public Boolean parse(String[] arguments) {
		if (arguments.length != 3)
			return false;
		IPAddress = arguments[0];
		port = Integer.parseInt(arguments[1]);
		file = arguments[2];
		return true;
	}

	public String getIPAddress() {
		return IPAddress;
	}

	public Integer getPort() {
		return port;
	}

	public String getFile() {
		return file;
	}
}
