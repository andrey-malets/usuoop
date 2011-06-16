package server;

import junit.framework.TestCase;

public class ArgumentParserTest extends TestCase {
	public void testGetPortWithoutParse() {
		ArgumentParser parser = new ArgumentParser();
		assertNull(parser.getPort());
	}
	
	public void testGetOutputFileWithoutParse() {
		ArgumentParser parser = new ArgumentParser();
		assertNull(parser.getOutputFile());
	}

	public void testParseWhenSingleArgument() {
		ArgumentParser parser = new ArgumentParser();
		assertFalse(parser.parse(new String[]{"80"}));
	}
	
	public void testParseWhenTwoArguments() {
		ArgumentParser parser = new ArgumentParser();
		assertTrue(parser.parse(new String[]{"80", "input.txt"}));
	}
		
	public void testGetPort(){
		ArgumentParser parser = new ArgumentParser();
		parser.parse(new String[]{"80", "input.txt"});
		assertEquals(new Integer(80), parser.getPort());
	}
	
	public void testGetOutputFile(){
		ArgumentParser parser = new ArgumentParser();
		parser.parse(new String[]{"80", "input.txt"});
		assertEquals("input.txt", parser.getOutputFile());
	}
}