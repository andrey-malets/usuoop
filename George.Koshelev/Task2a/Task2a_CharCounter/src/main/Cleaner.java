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
 * ������ ������ �� ������ ��������
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
 * ������ char[] �� ������ ��������
 * @param char[]
 * @return List<Character>
 */
	public List<Character> chooseCharacters(char[] buff){
			StringBuffer s = new StringBuffer();
			for (Character it: buff){
				s.append(it);
			}
			return chooseCharacters(s.toString());
	}
	public Pattern getRegExp() {
		return pattern;
	}

	public String getRegExpToString() {
		return pattern.toString();
	}

}
