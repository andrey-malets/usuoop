package Calculator;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import Exceptions.DifferentDimensions;
import Exceptions.DivisionByZeroException;
import Exceptions.OperationNotSupportedException;
import Exceptions.ParseValueException;
import Exceptions.ZeroDiscr;
import Fields.AbstractField;
import Parser.AbstractValueParser;

public class Calculator {
	public static String launch(String a, AbstractValueParser pars) throws Exception{
		return calculate(prepare(Caster.cast(a)),pars);		
	}
	private static ArrayList<String> prepare(String a){
		String list[] = a.split(" ");
		ArrayList<String> qwe = new ArrayList<String>();
		for (int i = 0; i < list.length; i++) {
			String EB_3C = list[i].replaceAll(" ", "");
			qwe.add(EB_3C);
		}
		return qwe;
	}
	private static String calculate(ArrayList<String> list,
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
