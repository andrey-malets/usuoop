#include <iostream>
#include <cassert>
#include "darray.h"

using std::cout;
using std::cerr;
using std::endl;
using std::string;

void test1(){
	try{
		int d = 23;
		DArray<int> a(10, d);
		assert(a.size() == 10);

		for(int i = 0; i != a.size(); ++i)
			assert(a[i] == d);

		a[16] = 13;
		assert(a.size() == 20);
		assert(a[16] == 13);
		for(int i = 0; i != 10; ++i)
			assert(a[i] == d);
	}
	catch(DArrayException* e){
		cerr << "Exception: " << e->getMessage() << endl;
	}

}

void test2()
{
	try{
		string d = "new test string";
		DArray<string> a(10, d);
		assert(a.size() == 10);

		for(int i = 0; i != a.size(); ++i)
			assert(a[i] == d);

		string tmp = "qwerty";
		a[16] = tmp;
		assert(a.size() == 20);
		assert(a[16] == tmp);
		for(int i = 0; i != 10; ++i)
			assert(a[i] == d);
		a[29] = tmp;
		for(int i = 0; i != 10; ++i)
			assert(a[i] == d);
		assert(a[16] == tmp);
		assert(a[29] == tmp);

	}
	catch(DArrayException* e){
		cerr << "Exception: " << e->getMessage() << endl;
	}

}

int main(){
	test1();
	test2();

	return 0;
}
