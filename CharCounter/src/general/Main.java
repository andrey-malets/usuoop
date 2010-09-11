package general;

public class Main {

	/**
	 * @param args
	 */  
  
	public static void main(String[] args) {
	  CharWorker charWorker = new CharWorker("[A1a]");
	  charWorker.update("ABCabc123");
	  System.out.println(charWorker);
	}
}
