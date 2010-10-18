package main;

public class Vector3D{
	private double x;
	private double y;
	private double z;

	public Vector3D() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}

	public Vector3D(double x) {
		this.x = x;
		this.y = 0;
		this.z = 0;
	}

	public Vector3D(double x, double y) {
		this.x = x;
		this.y = y;
		this.z = 0;
	}

	public Vector3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public double getZ() {
		return this.z;
	}

	public double scalar(Vector3D v) {
		return v.getX() * this.x + v.getY() * this.y + v.getZ() * this.z;
	}

	public double len() {
		return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2)
				+ Math.pow(this.z, 2));
	}

	public Vector3D multiply(double factor) {
		this.x *= factor;
		this.y *= factor;
		this.z *= factor;
		Vector3D vec = new Vector3D(this.x,this.y,this.z);
		return vec;
	}
	public Vector3D add(Vector3D v){
		this.x += v.getX();
		this.y += v.getY();
		this.z += v.getZ();
		Vector3D vec = new Vector3D(this.x,this.y,this.z);
		return vec;
	}
	public Vector3D sub(Vector3D v){
		this.x -= v.getX();
		this.y -= v.getY();
		this.z -= v.getZ();
		Vector3D vec = new Vector3D(this.x,this.y,this.z);
		return vec;
	}
	public String getCo(){
		StringBuffer a = new StringBuffer();
		a.append(this.x);
		a.append(this.y);
		a.append(this.z);
		return a.toString();
	}
	
}
