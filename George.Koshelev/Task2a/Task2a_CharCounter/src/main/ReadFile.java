package main;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFile {
	private final BufferedReader br;

	public ReadFile() throws FileNotFoundException {
		this.br = new BufferedReader(new InputStreamReader(new DataInputStream(
				new FileInputStream("src/main/main.txt"))));
	}

	public ReadFile(String way) throws FileNotFoundException {
		this.br = new BufferedReader(new InputStreamReader(new DataInputStream(
				new FileInputStream("src/main/".concat(way)))));
	}
/**
 * —читывает строку из файла
 * @return String 
 * @throws IOException
 */
	public String readString() throws IOException {
		String str = br.readLine();
		return str;
	}
/**
 * —читывает определенное количество символов с файла
 * @param length
 * @return String
 * @throws IOException
 */
	public char[] readBuff(int length) throws IOException{
		char [] cbuf = new char[length];
		br.read(cbuf,0,length);
		return cbuf;		
	}
/**
 * —читывает символ
 * @return char
 * @throws IOException
 */
	public char readChar() throws IOException{
		int a = br.read();
		return (char)a;
	}
/**
 * —читывает весь файл
 * @return String 
 * @throws IOException
 */
	public String readAll() throws IOException{
		String a,text = "";
		while ((a = br.readLine()) != null) {
			text += a;
		}
		return text;
	}
}
