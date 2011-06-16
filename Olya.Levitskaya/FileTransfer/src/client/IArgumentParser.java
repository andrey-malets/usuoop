package client;

public interface IArgumentParser {
	public Boolean parse(String[] arguments);
	public String getIPAddress();
	public Integer getPort();
	public String getFile();
}
