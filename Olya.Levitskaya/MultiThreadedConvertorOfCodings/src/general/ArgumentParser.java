package general;

public class ArgumentParser implements IArgumentParser{
	private String sourceFile;
	private String sourceEncoding;
	private String destinationFile;
	private String destinationEncoding;
	@Override
	public Boolean parse(String[] arguments) {
		if (arguments.length != 4)
			return false;
		sourceFile = arguments[0];
		sourceEncoding = arguments[1];
		destinationFile = arguments[2];
		destinationEncoding = arguments[3];
		return true;
	}

	@Override
	public String getSourceFile() {
		return sourceFile;
	}

	@Override
	public String getSourceEncoding() {
		return sourceEncoding;
	}

	@Override
	public String getDestinationFile() {
		return destinationFile;
	}

	@Override
	public String getDestinationEncoding() {
		return destinationEncoding;
	}

}
