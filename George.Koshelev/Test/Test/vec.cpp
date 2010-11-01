#include <iostream>
#include "iVector.h"
#include <vector>
#include "IntegerField.h"
#include "DoubleField.h"
using namespace std;

void main(){
	//Real a(1);
//	Real b(1);
	Integer c(3);
	Integer d(4);

	//Vector2D<Real> vec1(a,b);
	Vector2D<Integer> vec2(c,d);
	cout<< vec2.len().get();
}