package Calculator;

import java.util.Scanner;

import Exceptions.DifferentDimensions;
import Exceptions.DivisionByZeroException;
import Exceptions.OperationNotSupportedException;
import Exceptions.ParseValueException;
import Exceptions.ZeroDiscr;
import Parser.AbstractValueParser;
import Parser.ComplexValueParser;
import Parser.FractionValueParser;
import Parser.IntegerValueParser;
import Parser.RealValueParser;
import Parser.VectorIntegerValueParser;
import Parser.VectorRealValueParser;

public class Program {
	private final Scanner scanner;

	public Program(){
		this.scanner = new Scanner(System.in);
	}

	public String run() throws ParseValueException, OperationNotSupportedException, DifferentDimensions, DivisionByZeroException, ZeroDiscr, Exception {
		System.out
				.println("Choose mod for calculator:\n1.IntegerValues\n2.RealValues\n3.FractionValues\n4.ComplexValues\n5.Vectors(Integer)\n6.Vectors(Real)");
		int choose = scanner.nextInt();
		while (!(1 <= choose && choose <= 6)) {
			System.out
					.println("How do you think, is word 'mudak' rude or not? Re-enter value,please:");
			choose = scanner.nextInt();
		}
		System.out.println("Now enter your exspression");
		String str = scanner.next();
		String result = Calculator.launch(str,chooseParser(choose));
		return result;
	}
	public AbstractValueParser chooseParser(int a) {
		switch (a) {
		case 1: {
			IntegerValueParser parser = new IntegerValueParser();
			return parser;
		}
		case 2: {
			RealValueParser parser = new RealValueParser();
			return parser;
		}
		case 3: {
			FractionValueParser parser = new FractionValueParser();
			return parser;
		}
		case 4: {
			ComplexValueParser parser = new ComplexValueParser();
			return parser;
		}
		case 5: {
			VectorIntegerValueParser parser = new VectorIntegerValueParser();
			return parser;
		}
		case 6: {
			VectorRealValueParser parser = new VectorRealValueParser();
			return parser;
		}
		}
		return null;
	}
}
