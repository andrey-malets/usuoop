package test;

import general.ArgumentParser;
import general.IArgumentParser;
import junit.framework.TestCase;

public class ArgumentParserTest extends TestCase {
	public void testGetSourseFileWithoutParse() {
		IArgumentParser parser = new ArgumentParser();
		assertNull(parser.getSourceFile());
	}
	public void testGetSourseEncodingWithoutParse() {
		IArgumentParser parser = new ArgumentParser();
		assertNull(parser.getSourceEncoding());
	}
	public void testGetDestinationFileWithoutParse() {
		IArgumentParser parser = new ArgumentParser();
		assertNull(parser.getDestinationFile());
	}
	public void testGetDestinationEncodingWithoutParse() {
		IArgumentParser parser = new ArgumentParser();
		assertNull(parser.getDestinationEncoding());
	}
	public void testParseWhenSingleArgument() {
		IArgumentParser parser = new ArgumentParser();
		assertFalse(parser.parse(new String[]{"1.txt"}));
	}
	public void testParseWhenTwoArguments() {
		IArgumentParser parser = new ArgumentParser();
		assertFalse(parser.parse(new String[]{"1.txt","utf8"}));
	}
	public void testParseWhenThreeArguments() {
		IArgumentParser parser = new ArgumentParser();
		assertFalse(parser.parse(new String[]{"1.txt", "utf8", "2.txt"}));
	}
	public void testParseWhenFourArguments() {
		IArgumentParser parser = new ArgumentParser();
		assertTrue(parser.parse(new String[]{"1.txt", "utf8", "2.txt", "ascii"}));
	}
	public void testGetSourceFile(){
		IArgumentParser parser = new ArgumentParser();
		parser.parse(new String[]{"1.txt", "utf8", "2.txt", "ascii"});
		assertEquals("1.txt", parser.getSourceFile());
	}
	public void testGetSourceEncoding(){
		IArgumentParser parser = new ArgumentParser();
		parser.parse(new String[]{"1.txt", "utf8", "2.txt", "ascii"});
		assertEquals("utf8", parser.getSourceEncoding());
	}
	public void testGetDestinationFile(){
		IArgumentParser parser = new ArgumentParser();
		parser.parse(new String[]{"1.txt", "utf8", "2.txt", "ascii"});
		assertEquals("2.txt", parser.getDestinationFile());
	}
	public void testGetDestinationEncoding(){
		IArgumentParser parser = new ArgumentParser();
		parser.parse(new String[]{"1.txt", "utf8", "2.txt", "ascii"});
		assertEquals("ascii", parser.getDestinationEncoding());
	}
	
}