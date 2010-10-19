package general;

public class Vector3D implements Vector {

  private final double x;
  private final double y;
  private final double z;

  public Vector3D(double x,double y,double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }
  
  public double getX() { 
    return x;
  }

  public double getY() {
    return y;
  }

  public double getZ() {
    return z;
  }

  public Vector add(Vector rhs) {
    return new Vector3D(x+rhs.getX(),y+rhs.getY(),z+rhs.getZ());
  }

  public double scalar(Vector3D rhs) {    
    return x * rhs.getX() + y * rhs.getY() + z*rhs.getZ();
  }
}
