package server;

public interface INetworkCommunicator {
	public Boolean Configure(Integer port);
	public ReceiveResult Receive(byte[] outData);
}
