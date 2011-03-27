package test;

import general.Programme;
import junit.framework.TestCase;

public class Test1 extends TestCase {
	public void tsest11() {
		int a = 1;
		int b = 1;
		assertEquals(a, b);
	}
	public void test2() {
		String input = "11.txt";
		Programme.main(input);
	}
}

