import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

public class ClientServerTest extends TestCase{
	public void testSendFile() {
		File f = new File("output.txt");
		f.delete();
		
		Random random = new Random();
		int port = 6000 + random.nextInt(100);
		
		Thread server = new ServerThread(port);
		Thread client = new ClientThread(port);
		
		server.start();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			throw new AssertionError();
		}
		
		client.start();
		
		try {
			client.join(); //дождаться завершения клиентского потока
		} catch (InterruptedException e) {
			throw new AssertionError();
		}
		
		try {
			server.join();
		} catch (InterruptedException e) {
			throw new AssertionError();
		}
		
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
