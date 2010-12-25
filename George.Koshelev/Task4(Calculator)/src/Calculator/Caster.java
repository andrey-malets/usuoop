package Calculator;

import java.util.Stack;

public class Caster {
	public static String cast(String a) throws Exception {
		Stack<Character> stack = new Stack<Character>();
		StringBuffer sb = new StringBuffer();
		Validator.validString(a);
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
}
