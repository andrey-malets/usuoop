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
 * ��������� ������ �� �����
 * @return String 
 * @throws IOException
 */
	public String readString() throws IOException {
		String str = br.readLine();
		return str;
	}
/**
 * ��������� ������������ ���������� �������� � �����
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
 * ��������� ������
 * @return char
 * @throws IOException
 */
	public char readChar() throws IOException{
		int a = br.read();
		return (char)a;
	}
/**
 * ��������� ���� ����
 * @return String 
 * @throws IOException
 */
	public String readAll() throws IOException{
		String a = "";
		StringBuffer text = new StringBuffer();
		while ((a = br.readLine()) != null) {
			text.append(a);
		}
		return text.toString();
	}
}
