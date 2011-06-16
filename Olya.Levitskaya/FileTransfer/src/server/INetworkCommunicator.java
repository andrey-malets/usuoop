package server;

public interface INetworkCommunicator {
	public Boolean Configure(Integer port);
	public Boolean Receive(byte[] outData, int bytesRead);
}
