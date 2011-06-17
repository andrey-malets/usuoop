import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

public class ClientServerTest extends TestCase{
	public synchronized void testSendFile() {
		File f = new File("output.txt");
		f.delete();
		
		Thread server = new ServerThread();
		Thread client = new ClientThread();
		
		server.start();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			throw new AssertionError();
		}
		
		client.start();
		
		try {
			client.join();
		} catch (InterruptedException e) {
			throw new AssertionError();
		}

		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			throw new AssertionError();
		}

		server.stop();
		
		FileInputStream fis;
		try {
			fis = new FileInputStream("output.txt");
		} catch (FileNotFoundException e) {
			throw new AssertionFailedError();
		}
		
		byte[] actual = new byte[3];
		
		try {
			assertEquals(3, fis.read(actual));
		} catch (IOException e) {
			throw new AssertionFailedError();
		}
	}
}
