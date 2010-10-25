package segment;

import exceptions.MyException;
import vector.Vector;

public interface iSegment<K> {

	Vector<K> getStart();

	Vector<K> getEnd();

	double len() throws MyException;

	double distanceTo(Vector<K> point) throws MyException;
}
