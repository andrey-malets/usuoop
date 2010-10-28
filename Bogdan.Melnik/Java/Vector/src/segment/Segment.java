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
    return _end.sub(_start).getLength();
  }

  public double distanceTo(Vector point) throws MissmatchDimensionException, InvalidValueException {
    Vector a = _start.sub(point);
    Vector b = _end.sub(point);
    double cos = ( a.scalar(b).getValue() / ( a.getLength() * b.getLength() ) );
    double sin = Math.sin(Math.acos(cos));
    double S = a.getLength() * b.getLength() * sin;    
    return S/this.getLength();
  }
}
