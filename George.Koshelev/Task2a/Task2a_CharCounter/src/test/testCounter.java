package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import main.Counter;
import junit.framework.TestCase;

public class testCounter extends TestCase {
/**
 * �������� �� ������� �������� �� List<Character>
 */
	public void testcounter() {
		Counter co_1 = new Counter();
		Counter co_2 = new Counter();
		Counter co_3 = new Counter();
		List<Character> list_a = new ArrayList<Character>();
		List<Character> list_b = new ArrayList<Character>();
		Random rn = new Random(100);
		for (int i = 0; i < 10000; i++) {
			int a = 60 + Math.abs(rn.nextInt() % 60);
			list_a.add((char) a);
		}
		for (int i = 0; i < 10000; i++) {
			int a = 60 + Math.abs(rn.nextInt() % 60);
			list_b.add((char) a);
		}
		co_1.counter(list_a);
		Map<Character, Integer> map_a = co_1.getMap();

		co_2.counter(list_b);
		Map<Character, Integer> map_b = co_2.getMap();

		co_3.counter(list_a);
		co_3.counter(list_b);
		
		for (Character qw : map_a.keySet()) {
			if (map_b.containsKey(qw)) {
				map_b.put(qw, map_a.get(qw) + map_b.get(qw));
			} else {
				map_b.put(qw, map_a.get(qw));
			}
		}
		assertEquals(co_3.getMap(), map_b);
	}
	/**
	 * �������� �� ������� �������� � char[?] 
	 */
	public void testcounter_1(){
		Counter co_1 = new Counter();
		Counter co_2 = new Counter();
		Counter co_3 = new Counter();
		Character [] char_a = new Character[1000];
		Character [] char_b = new Character[1000];

		Random rn = new Random(100);
		for (int i = 0; i < 1000; i++) {
			int a = 60 + Math.abs(rn.nextInt() % 60);
			char_a[i] = (char)a;
		}
		for (int i = 0; i < 1000; i++) {
			int a = 60 + Math.abs(rn.nextInt() % 60);
			char_b[i] = ((char) a);
		}
		co_1.counter(char_a);
		Map<Character, Integer> map_a = co_1.getMap();

		co_2.counter(char_b);
		Map<Character, Integer> map_b = co_2.getMap();
		
		co_3.counter(char_a);
		co_3.counter(char_b);
		
		for (Character qw : map_a.keySet()) {
			if (map_b.containsKey(qw)) {
				map_b.put(qw, map_a.get(qw) + map_b.get(qw));
			} else {
				map_b.put(qw, map_a.get(qw));
			}
		}
		assertEquals(co_3.getMap(), map_b);
	}
}
