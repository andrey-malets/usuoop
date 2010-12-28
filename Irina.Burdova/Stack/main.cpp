#include <iostream>
#include <cassert>
#include "stack.h"

using std::cout;
using std::cerr;
using std::endl;
using std::string;

void test1(){
	try{
		double d = 1.23456;
		Stack<double> *s = new Stack<double>();
		assert(s->capacity() == 10);
		assert(s->size() == 0);

		s->push(d);
		assert(s->capacity() == 10);
		assert(s->size() == 1);

		double r= s->pop();
		assert(s->capacity() == 10);
		assert(s->size() == 0);
		assert(r == d);

		for(int i = 0; i != 15; ++i)
			s->push(d);
		assert(s->capacity() == 20);
		assert(s->size() == 15);

		for(int i = 0; i != 5; ++i)
			s->pop();
		assert(s->capacity() == 20);
		assert(s->size() == 10);
		
	}
	catch(StackException* e){
		cerr << "Exception: " << e->getMessage() << endl;
	}
}

int main(){
	test1();

	return 0;
}
