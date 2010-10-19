package vector;

public class OutOfComponentIndexException extends Exception {  
  private static final long serialVersionUID = 5346277142242214286L;

  public OutOfComponentIndexException(String error) {
    super(error);
  }  

}
