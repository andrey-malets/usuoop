package general;

public interface Vector {
  public double getX();
  public double getY();
  public double getZ();
  public Vector add(Vector rhs);
  double scalar(Vector3D v); 
}
