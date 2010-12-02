
package calculator.console;

import java.util.Scanner;

import calculator.AbstractValueParser;
import calculator.Calculator;
import calculator.datatypes.integer.IntegerValueParser;
import calculator.datatypes.real.RealValueParser;
import calculator.datatypes.vector.VectorValueParser;
import calculator.datatypes.rational.RationalValueParser;
import calculator.datatypes.complex.ComplexValueParser;

public class Program {

	private final Scanner scanner;

	private final Calculator calc;

	private AbstractValueParser[] valueParsers;

	public Program() {
		scanner = new Scanner(System.in);
		valueParsers = new AbstractValueParser[] { new IntegerValueParser(),
				new RealValueParser(), new VectorValueParser(), new RationalValueParser(), new ComplexValueParser() };
		AbstractValueParser parser = inputValueParser();
		System.out.println("Работаем с типом '" + parser.getDatatypeName()
				+ "'");
		if (parser.getDatatypeName() == "комплексные числа"){
			System.out.println("Формат строки: [+/-]1.0+2.5*i op [+/-]1.0+2.5*i");
		}
		if (parser.getDatatypeName() == "векторы"){
			System.out.println("Формат строки: ([+/-]1.0,[+/-]2.5) op ([+/-]1.0,[+/-]2.5)");
		}
		if (parser.getDatatypeName() == "рациональные числа"){
			System.out.println("Формат строки: [+/-]2/5 op [+/-]2/5)");
		}
		calc = new Calculator(parser);
	}

	private AbstractValueParser inputValueParser() {
		showChoises();
		int choise = scanner.nextInt();
		if (choise >= 1 && choise <= valueParsers.length)
			return valueParsers[choise - 1];
		else {
			System.out.println("Неверный выбор!");
			return inputValueParser();
		}
	}

	private void showChoises() {
		System.out.println("Вам нужно выбрать тип данных. Возможные варианты:");
		for (int i = 0; i < valueParsers.length; i++)
			System.out.println("  " + (i + 1) + ". "
					+ valueParsers[i].getDatatypeName());
	}

	public static void main(String args[]) {
		try {
			Program instance = new Program();
			instance.run(args);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private void run(String[] args) {
		while (true) {
			String arg1 = scanner.next();
			if (arg1.equals("exit"))
				break;
			String op = scanner.next();
			String arg2 = scanner.next();
			try {
				System.out.println(" = " + calc.calculate(arg1, op, arg2));

			} catch (Exception exception) {
				System.out.println(exception.getLocalizedMessage());
			}
		}
	}

}
