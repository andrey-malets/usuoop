package client;

public interface INetworkCommunicator {
	public Boolean Configure(String IPAddress, Integer port);
	public Boolean Send(byte[] data);
	public Boolean End();
}
