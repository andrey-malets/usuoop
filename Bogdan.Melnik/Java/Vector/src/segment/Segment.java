package segment;

import exceptions.InvalidValueException;
import exceptions.MissmatchDimensionException;
import vector.Vector;

public class Segment {
  
  private Vector _start;
  private Vector _end;

  public Segment(Vector start,Vector end) {
    _start = start;
    _end = end;
  }
  
  
  public Vector getStart() {    
    return new Vector(_start);
  }

  public Vector getEnd() {
    return new Vector(_end);
  }

  public double getLength() throws InvalidValueException, MissmatchDimensionException {
    return _start.sub(_end).getLength();    
  }

  public double distanceTo(Vector point) {
    return 0;
    
  }
}
