package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Counter {
	private final HashMap<Character, Integer> main_hash;

	public Counter() {
		main_hash = new HashMap<Character, Integer>();
	}
/**
 * ���������� � main_hash ���������� ������� ������� �� ����������� List<Character>
 * @param list
 */
	public void counter(List<Character> list) {
	Character [] l = list.toArray(new Character[list.size()]);
	counter(l);
	}
/**
* ���������� � main_hash ���������� ������� ������� �� ����������� char[] buff
* @param list
*/
	public void counter(Character []buff){
		for (final Character ch : buff) {
			if ((main_hash.get(ch)) != null) {
				main_hash.put(ch, main_hash.get(ch) + 1);
			} else {
				main_hash.put(ch, 1);
			}
		}
		/* List<Character> list = new ArrayList<Character>();
		for(char it: buff){
		 list.add(it);
	 }
		counter(list);
		*/
	}
/**
 * ���������� ����� main_hash
 * @return Map<Character,Integer>
 */
	public Map<Character, Integer> getMap() {
		Map<Character, Integer> map = new HashMap<Character, Integer>(main_hash);
		return map;
	}

	public String getHashToString() {
		return main_hash.toString();
	}
}
