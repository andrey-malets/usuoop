package client;

import junit.framework.TestCase;

public class ArgumentParserTest extends TestCase {
	public void testGetIPAddressWithoutParse() {
		ArgumentParser parser = new ArgumentParser();
		assertNull(parser.getIPAddress());
	}
	
	public void testGetPortWithoutParse() {
		ArgumentParser parser = new ArgumentParser();
		assertNull(parser.getPort());
	}
	
	public void testGetFileWithoutParse() {
		ArgumentParser parser = new ArgumentParser();
		assertNull(parser.getFile());
	}

	public void testParseWhenSingleArgument() {
		ArgumentParser parser = new ArgumentParser();
		assertFalse(parser.parse(new String[]{"127.0.0.1"}));
	}
	
	public void testParseWhenTwoArguments() {
		ArgumentParser parser = new ArgumentParser();
		assertFalse(parser.parse(new String[]{"127.0.0.1", "80"}));
	}
	
	public void testParseWhenThreeArguments() {
		ArgumentParser parser = new ArgumentParser();
		assertTrue(parser.parse(new String[]{"127.0.0.1", "80", "1.txt"}));
	}
	
	public void testGetIPAddress(){
		ArgumentParser parser = new ArgumentParser();
		parser.parse(new String[]{"127.0.0.1", "80", "1.txt"});
		assertEquals("127.0.0.1", parser.getIPAddress());
	}
	
	public void testGetPort(){
		ArgumentParser parser = new ArgumentParser();
		parser.parse(new String[]{"127.0.0.1", "80", "1.txt"});
		assertEquals(new Integer(80), parser.getPort());
	}
	
	public void testGetFile(){
		ArgumentParser parser = new ArgumentParser();
		parser.parse(new String[]{"127.0.0.1", "80", "1.txt"});
		assertEquals("1.txt", parser.getFile());
	}	
}