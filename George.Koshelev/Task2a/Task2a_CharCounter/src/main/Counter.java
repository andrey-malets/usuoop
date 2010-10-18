package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Counter {
	private final HashMap<Character, Integer> main_hash;

	public Counter() {
		main_hash = new HashMap<Character, Integer>();
	}
/**
 * Записывает в main_hash количество каждого символа из переданного List<Character>
 * @param list
 */
	public void counter(List<Character> list) {
		for (final Character ch : list) {
			if ((main_hash.get(ch)) != null) {
				main_hash.put(ch, main_hash.get(ch) + 1);
			} else {
				main_hash.put(ch, 1);
			}
		}
	}
/**
* Записывает в main_hash количество каждого символа из переданного char[] buff
* @param list
*/
	public void counter(char []buff){
	 List<Character> list = new ArrayList<Character>();
		for(char it: buff){
		 list.add(it);
	 }
		counter(list);
	}
/**
 * Возвращает копию main_hash
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
