package main;

import java.io.IOException;

public class Main {
public static void main(String[] arg) throws IOException{
		Counter co = new Counter();
		Cleaner cl = new Cleaner("[A-Za-z0-9]");
		ReadFile reader = new ReadFile();
		co.counter(cl.chooseCharacters(reader.readAll()));
		System.out.println(co.getMap());
}
}
