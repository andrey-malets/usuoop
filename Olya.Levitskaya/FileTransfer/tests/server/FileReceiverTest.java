package server;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

public class FileReceiverTest extends TestCase{
	
	public void testReceiveFileWithConfigureError() {
		ArgumentParser parser = new ArgumentParser();
		parser.parse(new String[]{"80", "output.txt"});
		
		NetworkCommunicatorTestImpl networkCommunicator = new NetworkCommunicatorTestImpl();
		networkCommunicator.ExpectConfigure(80, false);
		assertFalse(new FileReceiver(parser, networkCommunicator).ReceiveFile());
		assertTrue(networkCommunicator.GetExpectationResult());
	}
	
	public void testReceiveFileWithNetworkError() {
		ArgumentParser parser = new ArgumentParser();
		parser.parse(new String[]{"80", "output.txt"});
		
		NetworkCommunicatorTestImpl networkCommunicator = new NetworkCommunicatorTestImpl();
		networkCommunicator.ExpectConfigure(80, true);
		
		networkCommunicator.ExpectReceive(new byte[0], new ReceiveResult(false, -1));
		assertFalse(new FileReceiver(parser, networkCommunicator).ReceiveFile());
		assertTrue(networkCommunicator.GetExpectationResult());
	}
	
	public void testReceiveFileWithEndConnectionError() {
		ArgumentParser parser = new ArgumentParser();
		parser.parse(new String[]{"80", "output.txt"});
		
		NetworkCommunicatorTestImpl networkCommunicator = new NetworkCommunicatorTestImpl();
		networkCommunicator.ExpectConfigure(80, true);
		
		networkCommunicator.ExpectReceive(new byte[0], new ReceiveResult(true, 0));
		networkCommunicator.ExpectEnd(false);
		assertFalse(new FileReceiver(parser, networkCommunicator).ReceiveFile());
		assertTrue(networkCommunicator.GetExpectationResult());
	}
	
	public void testReceiveFile() {
		ArgumentParser parser = new ArgumentParser();
		parser.parse(new String[]{"80", "output.txt"});
		
		NetworkCommunicatorTestImpl networkCommunicator = new NetworkCommunicatorTestImpl();
		networkCommunicator.ExpectConfigure(80, true);
		
		networkCommunicator.ExpectReceive(new byte[0], new ReceiveResult(true, 0));
		networkCommunicator.ExpectEnd(true);
		assertTrue(new FileReceiver(parser, networkCommunicator).ReceiveFile());
		
		assertTrue(networkCommunicator.GetExpectationResult());
		
		FileInputStream fis;
		try {
			fis = new FileInputStream("output.txt");
		} catch (FileNotFoundException e) {
			throw new AssertionFailedError();
		}
		
		byte[] actual = new byte[1];
		
		try {
			assertEquals(-1, fis.read(actual));
		} catch (IOException e) {
			throw new AssertionFailedError();
		}
					
		try {
			fis.close();
		} catch (IOException e) {
			throw new AssertionFailedError();
		}
	}
}
