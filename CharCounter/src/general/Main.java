package general;

import model.CharWorker;
import view.MySimpleView;

public class Main {

	/**
	 * @param args
	 */  
  
	public static void main(String[] args) {
	  CharWorker charWorker = new CharWorker("[1a]");
	  charWorker.update("ABCab\nc123");
	  System.out.println(new MySimpleView(charWorker).getRepresentation());
	}
}
