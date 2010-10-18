package main;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cleaner {
	private final Pattern pattern;

	public Cleaner() {
		pattern = Pattern.compile("([A-Za-z])");
	}

	public Cleaner(String str) {
		pattern = Pattern.compile(str);
	}
/**
 * Чистит строку от лишних символов
 * @param String
 * @return List<Character>
 */
	public List<Character> chooseCharacters(String str) {
		Matcher m = pattern.matcher(str);
		List<Character> list = new ArrayList<Character>();
		while (m.find()) {
			String s = m.group();
			Character ch = s.charAt(0);
			list.add(ch);
		}
		return list;
	}
/**
 * Чистит char[] от лишних символов
 * @param char[]
 * @return List<Character>
 */
	public List<Character> chooseCharacters(char[] buff){
			String s = "";
			for (Character it: buff){
				s+=it;
			}
			return chooseCharacters(s);
	}
	public Pattern getRegExp() {
		return pattern;
	}

	public String getRegExpToString() {
		return pattern.toString();
	}

}
