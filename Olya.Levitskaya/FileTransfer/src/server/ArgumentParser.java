package server;

public class ArgumentParser{
	private Integer port;
	private String outputFile;
	
	public Boolean parse(String[] arguments) {
		if (arguments.length != 2)
			return false;
		port = Integer.parseInt(arguments[0]);
		outputFile = arguments[1];
		return true;
	}

	public Integer getPort() {
		return port;
	}

	public String getOutputFile() {
		return outputFile;
	}
}
