#include <iostream>
#include "IntegerValue.h"
#include "Caster.h"
using namespace std;
int main(){
	IntegerValue a = 3;
	IntegerValue b = 0;
	a.add(b);
	Caster *c = new Caster();
	c->cast("1+2+(1*3)=");
	return 0;
}