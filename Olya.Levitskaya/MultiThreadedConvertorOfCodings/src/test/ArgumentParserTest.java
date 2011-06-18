package test;

import general.ArgumentParser;
import junit.framework.TestCase;

public class ArgumentParserTest extends TestCase {
	public void testGetSourseFileWithoutParse() {
		ArgumentParser parser = new ArgumentParser();
		assertNull(parser.getSourceFile());
	}
	public void testGetSourseEncodingWithoutParse() {
		ArgumentParser parser = new ArgumentParser();
		assertNull(parser.getSourceEncoding());
	}
	public void testGetDestinationFileWithoutParse() {
		ArgumentParser parser = new ArgumentParser();
		assertNull(parser.getDestinationFile());
	}
	public void testGetDestinationEncodingWithoutParse() {
		ArgumentParser parser = new ArgumentParser();
		assertNull(parser.getDestinationEncoding());
	}
	public void testParseWhenSingleArgument() {
		ArgumentParser parser = new ArgumentParser();
		assertFalse(parser.parse(new String[]{"1.txt"}));
	}
	public void testParseWhenTwoArguments() {
		ArgumentParser parser = new ArgumentParser();
		assertFalse(parser.parse(new String[]{"1.txt","utf8"}));
	}
	public void testParseWhenThreeArguments() {
		ArgumentParser parser = new ArgumentParser();
		assertFalse(parser.parse(new String[]{"1.txt", "utf8", "2.txt"}));
	}
	public void testParseWhenFourArguments() {
		ArgumentParser parser = new ArgumentParser();
		assertTrue(parser.parse(new String[]{"1.txt", "utf8", "2.txt", "ascii"}));
	}
	public void testGetSourceFile(){
		ArgumentParser parser = new ArgumentParser();
		parser.parse(new String[]{"1.txt", "utf8", "2.txt", "ascii"});
		assertEquals("1.txt", parser.getSourceFile());
	}
	public void testGetSourceEncoding(){
		ArgumentParser parser = new ArgumentParser();
		parser.parse(new String[]{"1.txt", "utf8", "2.txt", "ascii"});
		assertEquals("utf8", parser.getSourceEncoding());
	}
	public void testGetDestinationFile(){
		ArgumentParser parser = new ArgumentParser();
		parser.parse(new String[]{"1.txt", "utf8", "2.txt", "ascii"});
		assertEquals("2.txt", parser.getDestinationFile());
	}
	public void testGetDestinationEncoding(){
		ArgumentParser parser = new ArgumentParser();
		parser.parse(new String[]{"1.txt", "utf8", "2.txt", "ascii"});
		assertEquals("ascii", parser.getDestinationEncoding());
	}
}