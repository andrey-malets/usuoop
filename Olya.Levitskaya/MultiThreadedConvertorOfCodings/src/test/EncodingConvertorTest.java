package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

import junit.framework.TestCase;
import general.ArgumentParser;
import general.EncodingConvertor;
import general.IArgumentParser;

public class EncodingConvertorTest extends TestCase{
	public void testNoSourceFile() {
		IArgumentParser parser = new ArgumentParser();
		parser.parse(new String[]{"nonExistingFile.txt", "utf8", "2.txt", "ascii"});
		EncodingConvertor convertor = new EncodingConvertor(parser);
		assertFalse(convertor.convert());
	}
	public void testNoSourceEncoding() {
		IArgumentParser parser = new ArgumentParser();
		parser.parse(new String[]{"1.txt", "encoding", "2.txt", "ascii"});
		EncodingConvertor convertor = new EncodingConvertor(parser);
		assertFalse(convertor.convert());
	}
	public void testNoDestinationEncoding() {
		IArgumentParser parser = new ArgumentParser();
		parser.parse(new String[]{"1.txt", "utf8", "2.txt", "encoding"});
		EncodingConvertor convertor = new EncodingConvertor(parser);
		assertFalse(convertor.convert());
	}
	public void testConvert() throws IOException {
		char[] expectedContent = new char[]{'а', 'б', 'в'};
		FileOutputStream fos = new FileOutputStream("1.txt");
		Writer osw = new OutputStreamWriter(fos, "UTF8");
		osw.write(expectedContent);
		osw.close();
		
		IArgumentParser parser = new ArgumentParser();
		parser.parse(new String[]{"1.txt", "UTF8", "2.txt", "cp1251"});
		EncodingConvertor convertor = new EncodingConvertor(parser);
		assertTrue(convertor.convert());
		
		char[] buffer = new char[3];
		FileInputStream fis = new FileInputStream("2.txt");
		InputStreamReader isr = new InputStreamReader(fis, "cp1251");
		isr.read(buffer);
		for(int i = 0; i < 3; i++)
			assertEquals(expectedContent[i], buffer[i]);
	}
}