package Calculator;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Exceptions.DifferentDimensions;
import Exceptions.DivisionByZeroException;
import Exceptions.OperationNotSupportedException;
import Exceptions.ParseValueException;
import Exceptions.ZeroDiscr;
import Fields.AbstractField;
import Parser.AbstractValueParser;

public class Calculator {

	private final Pattern pat;

	public Calculator() {
		this.pat = Pattern.compile("[^0-9+*;().=/<>:-]");
	}

	public void validString(String a) throws Exception {
		Matcher m = pat.matcher(a);
		if (m.find()) {
			throw new Exception("Wrong symbols in string");
		}
	}

	public String run(String a) throws Exception {
		Stack<Character> stack = new Stack<Character>();
		StringBuffer sb = new StringBuffer();
		validString(a);
		Character ch = null;
		char c = 0;
		int i = 0;
		while (c != '=' && i < a.length()) {
			c = a.charAt(i);
			if (c == ')') {
				while ((ch = stack.pop()) != '(') {
					if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {
						sb.append(' ');
					}
					sb.append(ch);
				}
			}
			if (c == '(') {
				stack.push(c);
			}
			if ((c >= '0' && c <= '9') || c == '<' || c == '>' || c == ';'
					|| c == '.'||c == ':') {
				sb.append(c);
			}
			if (c == '+' || c == '-' || c == '*' || c == '/') {
				sb.append(" ");
				if (stack.empty()) {
					stack.push(c);
				} else {
					if (prior(c) > prior(stack.lastElement())) {
						stack.push(c);
					} else {
						while (!(stack.isEmpty())
								&& prior(c) <= prior(stack.lastElement())) {
							sb.append(stack.pop());
							sb.append(' ');
						}
						stack.push(c);
					}
				}
			}
			i++;
		}
		while (!(stack.isEmpty())) {
			sb.append(' ');
			sb.append(stack.pop());
		}
		return sb.toString();
	}

	private static int prior(char a) {
		int p = 0;
		switch (a) {
		case '*': {
			p = 3;
			break;
		}
		case '/': {
			p = 3;
			break;
		}
		case '-': {
			p = 2;
			break;
		}
		case '+': {
			p = 2;
			break;
		}
		case '(': {
			p = 1;
		}
		}
		return p;
	}

	public static ArrayList<String> prepare(String a) {
		if (a.charAt(0) == ' ') {
			a = a.substring(1, a.length());
		}
		String list[] = a.split(" ");
		ArrayList<String> qwe = new ArrayList<String>();
		for (int i = 0; i < list.length; i++) {
			String EB_3C = list[i].replaceAll(" ", "");
			qwe.add(EB_3C);
		}
		return qwe;
	}

	public static String calculate(ArrayList<String> list,
			AbstractValueParser parser) throws ParseValueException,
			OperationNotSupportedException, DifferentDimensions,
			DivisionByZeroException, ZeroDiscr {
		Stack<String> stack = new Stack<String>();
		Iterator<String> i = list.iterator();
		while (i.hasNext()) {
			String str = i.next();
			if (!str.equals("+")&&!str.equals("-")&&!str.equals("*")&&!str.equals("/")){
				stack.push(str);
			} else {
					String a = stack.pop();
					String b = stack.pop();
					AbstractField f1 = parser.parse(a);
					AbstractField f2 = parser.parse(b);
					if (str.equals("+")) {
						stack.push((f2.add(f1)).toString());
					}
					if (str.equals("-")) {
						stack.push((f2.sub(f1)).toString());
					}
					if (str.equals("/")) {
						stack.push((f2.div(f1)).toString());
					}
					if (str.equals("*")) {
						stack.push((f2.mul(f1)).toString());
					}
				}
			}
		return stack.pop().toString();
	}
}
