package testSegment;

import java.util.Random;

import exceptions.MyException;
import field.RealNumbField;
import segment.Segment;
import vector.Vector2D;
import junit.framework.TestCase;

public class TestSegment extends TestCase {
public void testDistanceTo1() throws MyException{
	Random rn = new Random();
	RealNumbField[] comp = new RealNumbField[2];
	comp[0] = new RealNumbField(rn.nextDouble());
	comp[1] = new RealNumbField(rn.nextDouble());
	Vector2D<Double> vec = new Vector2D<Double>(comp);
	RealNumbField[] comp1 = new RealNumbField[2];
	comp1[0] = new RealNumbField(rn.nextDouble());
	comp1[1] = new RealNumbField(rn.nextDouble());
	Vector2D<Double> vec1 = new Vector2D<Double>(comp1);
	RealNumbField[] comp2 = new RealNumbField[2];
	comp2[0] = comp[0];
	comp2[1] = comp1[1];
	Vector2D<Double> point1 = new Vector2D<Double>(comp2);
	Segment<Double> seg = new Segment<Double>(vec, vec1);
	RealNumbField[] comp3 = new RealNumbField[2];
	comp3[0] = comp1[0];
	comp3[1] = comp[1];
	Vector2D<Double> point2 = new Vector2D<Double>(comp2);
	assertEquals(seg.distanceTo(point1), seg.distanceTo(point2));
	}

}
