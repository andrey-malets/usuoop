package client;

import junit.framework.TestCase;

public class FileSenderTest extends TestCase{
	public void testSendFileWithConfigureError() {
		ArgumentParser parser = new ArgumentParser();
		parser.parse(new String[]{"incorrectIP", "80", "nonexistingfile.txt"});
		
		NetworkCommunicatorTestImpl networkCommunicator = new NetworkCommunicatorTestImpl();
		networkCommunicator.ExpectConfigure("incorrectIP", 80, false);
		assertFalse(new FileSender(parser, networkCommunicator).SendFile());
		assertTrue(networkCommunicator.GetExpectationResult());
	}

	public void testSendFileForNonExistingFile() {
		ArgumentParser parser = new ArgumentParser();
		parser.parse(new String[]{"127.0.0.1", "80", "nonexistingfile.txt"});
		
		NetworkCommunicatorTestImpl networkCommunicator = new NetworkCommunicatorTestImpl();
		networkCommunicator.ExpectConfigure("127.0.0.1", 80, true);
		assertFalse(new FileSender(parser, networkCommunicator).SendFile());
		assertTrue(networkCommunicator.GetExpectationResult());
	}
	
	public void testSendFileWithNetworkError() {
		ArgumentParser parser = new ArgumentParser();
		parser.parse(new String[]{"127.0.0.1", "80", "1.txt"});
		
		NetworkCommunicatorTestImpl networkCommunicator = new NetworkCommunicatorTestImpl();
		networkCommunicator.ExpectConfigure("127.0.0.1", 80, true);
		
		networkCommunicator.ExpectSend(new byte[]{'1', '2', '3'}, false);
		assertFalse(new FileSender(parser, networkCommunicator).SendFile());
		assertTrue(networkCommunicator.GetExpectationResult());
	}
	
	public void testSendFile() {
		ArgumentParser parser = new ArgumentParser();
		parser.parse(new String[]{"127.0.0.1", "80", "1.txt"});
		
		NetworkCommunicatorTestImpl networkCommunicator = new NetworkCommunicatorTestImpl();
		networkCommunicator.ExpectConfigure("127.0.0.1", 80, true);
		
		networkCommunicator.ExpectSend(new byte[]{'1', '2', '3'}, true);
		assertTrue(new FileSender(parser, networkCommunicator).SendFile());
		assertTrue(networkCommunicator.GetExpectationResult());
	}
}
