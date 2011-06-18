package general;

public class Programme {
	public static void main(String[] args) {
		ArgumentParser parser = new ArgumentParser();
		if(!parser.parse(args)){
			System.out.println("Error in Arguments");
			return;
		}
		
		EncodingConvertor convertor = new EncodingConvertor(parser);
		if(!convertor.convert()) {
			System.out.println("Error in convertation");
			return;
		}
	}
}
