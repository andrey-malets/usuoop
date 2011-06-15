package general;

public class Programme {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IArgumentParser parser = new ArgumentParser();
		parser.parse(args);
		EncodingConvertor convertor = new EncodingConvertor(parser);
		convertor.convert();
	}
}