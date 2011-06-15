package general;

public interface IArgumentParser {
	public Boolean parse(String[] arguments);
	public String getSourceFile();
	public String getSourceEncoding();
	public String getDestinationFile();
	public String getDestinationEncoding();
}
