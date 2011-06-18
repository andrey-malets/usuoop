package general;

public class ArgumentParser{
	private String sourceFile;
	private String sourceEncoding;
	private String destinationFile;
	private String destinationEncoding;
	
	public Boolean parse(String[] arguments) {
		if (arguments.length != 4)
			return false;
		sourceFile = arguments[0];
		sourceEncoding = arguments[1];
		destinationFile = arguments[2];
		destinationEncoding = arguments[3];
		return true;
	}
	
	public String getSourceFile() {
		return sourceFile;
	}

	public String getSourceEncoding() {
		return sourceEncoding;
	}

	public String getDestinationFile() {
		return destinationFile;
	}

	public String getDestinationEncoding() {
		return destinationEncoding;
	}
}
