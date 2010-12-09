#include <iostream>

#include "stack/stack.cpp"

int main () {
	Stack<int> stack;
	
	if(!stack.isempty())
		return 4;
	
	for (int i = 0; i < 100; ++i)
		stack.push(i);

	if(stack.isempty())
		return 3;
		
	for (int i = 0; i < 100; ++i)
		if(stack.pop() != 100 - i - 1)
			return 2;
	
	if(!stack.isempty())
		return 3;
	
	return 0;
}
