package general;

public class Programme {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length > 0) {
			String inputFile = args[0];
			/*
			 * String inputCoding = args[1]; String outputFile = args[2]; String
			 * outputCoding = args[3];
			 */
			ReadInputFile.test(inputFile);

		} else {
			String inputFile = "11.txt";
		}
		Programme program = new Programme();

	}
}
