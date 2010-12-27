#include <iostream>

#include "queue/queue.cpp"

using namespace std;

int main () {
	Queue<int> queue;
	
	if(!queue.isempty())
		return 4;
	
	for (int i = 0; i < 100; ++i)
		queue.push(i);

	if (queue.isempty())
		return 3;
		
	for (int i = 0; i < 100; ++i)
		if(queue.shift() != i)
			return 2;
	
	if(!queue.isempty())
		return 3;
	
	return 0;
}
