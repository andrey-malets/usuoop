template <class T,int pol>
class Stack{
private:
	int maxValue;
	T *currentPointer;
	int currentValue;
	int policy;
	MemoryManager<T,pol> manager;
public:
	Stack(){
		policy = pol;
		currentPointer = 0;
		currentValue = 0;
		maxValue = 0;
	}
	~Stack(){};
	void push(T pushValue){
		if (isEmpty()){
			currentPointer = manager.giveEmptyMemory();
			currentPointer[currentValue] = pushValue;
			currentValue++;
			maxValue = policy;
		}
		else{
			if (currentValue==maxValue){
				currentPointer = manager.increaseMaxSize(currentPointer,maxValue);
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
		if (currentValue==0){
			throw "Stack is empty\n";
		}
		if (maxValue == currentValue*policy){
			currentPointer = manager.decreaseMaxSize(currentPointer,currentValue);
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
	T lastOf(){ 
		return	currentPointer[currentValue-1];
	}
};
