#include <iostream>
#include "Stack.h"
//#include "Queue.h"
int main(){
	Stack<int,2> queue;
	queue.push(2);
	queue.push(1);
	std::cout<<queue.pop();
std::cout<<queue.pop();
queue.push(2);
	queue.push(1);
	std::cout<<queue.pop();
std::cout<<queue.pop();

	return 0;
}