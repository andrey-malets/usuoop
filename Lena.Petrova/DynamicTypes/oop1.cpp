#include <iostream>
#include "alloc.h"
#include "stack.h"
#include "dynarray.h"
#include "queue.h"

using namespace std;

bool testDynArray(){
	bool res = true;
	typedef DynArray<int> Array;
	Array ar1 = Array(4);
	for (int i=0; i<200; ++i){
		ar1[i] = i;
	}
	Array ar2 = ar1;
	for (int i=0; i<200; ++i){
		res&=(ar2[i] == i);
	}
	return res;
}

bool testStack(){
	bool res = true;
	typedef Stack<int> stack;
	stack s1 = stack(5);
	for (int i=0; i<200; ++i){
		s1.push(i);
	}
	stack s2 = s1;
	for (int i=199; i>=0; --i){
		res&=(s2.pop() == i);
	}
	return res;
}

bool testQueue(){
	bool res = true;
	typedef myQueue<int> queue;
	queue q1 = queue();
	for (int i=0; i<260; ++i){
		q1.add(i);
	}
	for (int i=0; i<260; ++i){
		res&=(q1.get()==i);
	}
	return res;
}

int main()
{
	cout<<"Dynamic Arrays:\t"<<(testDynArray()?"OK!":"FAIL")<<endl;
	cout<<"Stack:\t\t"<<(testStack()?"OK!":"FAIL")<<endl;
	cout<<"Queue:\t\t"<<(testQueue()?"OK!":"FAIL")<<endl;
	
	
	Stack<int> s1;
	Stack<int, hisAllocPolicy> s2;
	s2 = s1;
	s1 = s1;

	return 0;
}
