package client;

public class NetworkCommunicatorTestImpl implements INetworkCommunicator{
	private Boolean expectationResult = false;
	private String expectedIPAddress;
	private Integer expectedPort;
	private Boolean expectedConfigureResult;
	private byte[] expectedData;
	private Boolean expectedSendResult;
	private Boolean expectedEndResult;
	
	public Boolean GetExpectationResult(){
		return expectationResult;
	}
	
	public Boolean Configure(String IPAddress, Integer port) {
		expectationResult = false;
		if (expectedIPAddress.equals(IPAddress) && expectedPort.equals(port))
			expectationResult = true;
		return expectedConfigureResult;
	}
	
	public void ExpectConfigure(String IPAddress, Integer port, Boolean configureResult){
		expectedIPAddress = IPAddress;
		expectedPort = port;
		expectedConfigureResult = configureResult;
	}
	
	public Boolean Send(byte[] data) {
		expectationResult = false;
		if (expectedData.length == data.length){
			Boolean isArrayEquals = true;
			for (int i = 0; i < expectedData.length; i++){
				if (expectedData[i] != data[i]){
					isArrayEquals = false;
					break;
				}
			}
			if (isArrayEquals)
				expectationResult = true;	
		}
		return expectedSendResult;
	}
	
	public void ExpectSend(byte[] data, Boolean sendResult){
		expectedData = data;
		expectedSendResult = sendResult;
	}
	
	public Boolean End(){
		expectationResult = true;
		return expectedEndResult;
	}
	
	public void ExpectEnd(Boolean endResult){
		expectedEndResult = endResult;
	}
}
