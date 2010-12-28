package lexer.datatype;

public interface AbstractValue {
  public AbstractValue add(AbstractValue av) throws TypeMissmatchException;
  public AbstractValue sub(AbstractValue av) throws TypeMissmatchException;
  public AbstractValue mul(AbstractValue av) throws TypeMissmatchException;
  public AbstractValue div(AbstractValue av) throws TypeMissmatchException;
}