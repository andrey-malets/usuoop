#include <iostream>

//#include "pseudo_alloc.h"
#include "Queue.h"
#include "Stack.h"
int main(){
/*
	Queue<int> queue;
	queue.push(2);
	std::cout<<queue.pop();
	queue.push(1);
	queue.push(3);
	std::cout<<queue.pop();
	std::cout<<queue.pop();
*/
	Stack<int,2> stack;
	stack.push(1);
	stack.push(1);
stack.push(1);
stack.push(1);
stack.push(1);
stack.push(1);
std::cout<<stack.pop();
std::cout<<stack.pop();
std::cout<<stack.pop();
std::cout<<stack.pop();
std::cout<<stack.pop();
std::cout<<stack.pop();
stack.push(2);
stack.push(2);
stack.push(2);
stack.push(2);
stack.push(2);
stack.push(2);
std::cout<<stack.pop();
std::cout<<stack.pop();
std::cout<<stack.pop();
std::cout<<stack.pop();
std::cout<<stack.pop();
std::cout<<stack.pop();

	return 0;
}