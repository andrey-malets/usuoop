package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import junit.framework.TestCase;
import main.Cleaner;

public class testCleaner extends TestCase{
	/**
	 * ѕровер€ет как производитс€ очистка строки при помощи одного Cleaner-а
	 */
public void testcleaner_1(){
		Cleaner cl = new Cleaner("[A-Za-z]");
		String str_new = "";
		List<Character> list  = new ArrayList<Character>();
		Random rn = new Random(100);
		for (int i = 0; i < 1000; i++) {
			int a = 60 + Math.abs(rn.nextInt() % 60);
			if (a>=65&a<=90|a>=97&a<=122){list.add((char)a);}
			str_new += ((char) a);
		}
		assertEquals(cl.chooseCharacters(str_new),list);
}
/**
 * ѕровер€ет как разные объекты класса Cleaner ведут себ€ при одинаковом переданнном аргуменет типа String
 */
public void testcleaner_2(){
	Cleaner cl_1 = new Cleaner("[A-Za-z]");
	Cleaner cl_2 = new Cleaner("[A-Za-z]");
	String str_new = "";
	Random rn = new Random(100);
	for (int i = 0; i < 1000; i++) {
		int a = 60 + Math.abs(rn.nextInt() % 60);
		str_new += ((char) a);
	}
	assertEquals(cl_1.chooseCharacters(str_new), cl_2.chooseCharacters(str_new));
}
/**
 * ѕровер€ет как производитс€ очистка массива char при помощи одного Cleaner-а 
 */
public void testcleaner_3(){
	Cleaner cl = new Cleaner("[A-Za-z]");
	List<Character> list  = new ArrayList<Character>();
	char[] ch_b = new char[1000];
	Random rn = new Random(100);
	for (int i = 0; i < 1000; i++) {
		int a = 60 + Math.abs(rn.nextInt() % 60);
		if (a>=65&a<=90|a>=97&a<=122){list.add((char)a);}
		ch_b[i] = (char) a;
	}
	assertEquals(cl.chooseCharacters(ch_b),list);
}
/**
 * ѕровер€ет как разные объекты класса Cleaner ведут себ€ при одинаковом переданнном аргуменет типа char[]
 */
public void testcleaner_4(){
	Cleaner cl_1 = new Cleaner("[A-Za-z]");
	Cleaner cl_2 = new Cleaner("[A-Za-z]");
	char[] ch_a = new char[1000];
	Random rn = new Random(100);
	for (int i = 0; i < 1000; i++) {
		int a = 60 + Math.abs(rn.nextInt() % 60);
		ch_a[i] = (char)a;
	}
	assertEquals(cl_1.chooseCharacters(ch_a), cl_2.chooseCharacters(ch_a));
}
}
