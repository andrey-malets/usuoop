package server;

public class NetworkCommunicatorTestImpl implements INetworkCommunicator{
	private Boolean expectationResult = false;
	private Integer expectedPort;
	private Boolean expectedConfigureResult;
	private byte[] expectedOutData;
	private ReceiveResult expectedReceiveResult;
	
	public Boolean GetExpectationResult(){
		return expectationResult;
	}
	
	public Boolean Configure(Integer port) {
		expectationResult = false;
		if (expectedPort.equals(port))
			expectationResult = true;
		return expectedConfigureResult;
	}
	
	public void ExpectConfigure(Integer port, Boolean configureResult){
		expectedPort = port;
		expectedConfigureResult = configureResult;
	}
	
	public ReceiveResult Receive(byte[] outData) {
		expectationResult = true;
		for (int i = 0; i < expectedOutData.length; i++)
			outData[i] = expectedOutData[i];
		return expectedReceiveResult;
	}
	
	public void ExpectReceive(byte[] outData, ReceiveResult receiveResult){
		expectedOutData = new byte[outData.length];
		for (int i = 0; i < outData.length; i++)
			expectedOutData[i] = outData[i];
		expectedReceiveResult = receiveResult;
	}
}
