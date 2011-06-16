package client;

public class ArgumentParser implements IArgumentParser{
	private String IPAddress;
	private Integer port;
	private String file;
	
	@Override
	public Boolean parse(String[] arguments) {
		if (arguments.length != 3)
			return false;
		IPAddress = arguments[0];
		port = Integer.parseInt(arguments[1]);
		file = arguments[2];
		return true;
	}

	@Override
	public String getIPAddress() {
		return IPAddress;
	}

	@Override
	public Integer getPort() {
		return port;
	}

	@Override
	public String getFile() {
		return file;
	}
}
