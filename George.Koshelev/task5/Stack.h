#include "pseudo_alloc.h"
template <class T,int pol>
class Stack{
private:
	int maxValue;
	T *currentPointer;
	int currentValue;
	int policy;
	Allocator<T> al;
public:
	Stack(){
		policy = pol;
		currentPointer = 0;
		currentValue = 0;
		maxValue = 0;
	}
	void push(T pushValue){
		if (isEmpty()){
			currentPointer = al.giveMemory(policy);
			currentPointer[currentValue] = pushValue;
			currentValue++;
			maxValue = policy;
		}
		else{
			if (currentValue==maxValue){
				currentPointer = al.addMemory(currentPointer,currentValue,policy);
				currentPointer[currentValue] = pushValue;
				maxValue*=policy;
				currentValue++;
			}
			else{
				currentPointer[currentValue] = pushValue;
				currentValue++;
			}
		}
	}
	T pop(){
		if (currentValue==0)
			throw "Stack is empty\n";
		if (maxValue == currentValue*policy){
			currentPointer = al.reduceMemory(currentPointer,currentValue);
			maxValue = currentValue;
		}
		currentValue--;
		return currentPointer[currentValue];	
	}
	bool isEmpty(){
		if (currentValue==0){
			return true;
		}
		return false;
	}
};
