template <class T>
class Array{
private:
	int val_quant;
	int capacity;
	int right_border;
	T* current_pointer;
	Stack<T,2> stack;
	MemoryManager<T,2> manager;
public:
	Array():val_quant(0),capacity(0),right_border(0){
	stack.push(-1);
	};
	~Array(){};
	T at(int i){
		if (i<=right_border){
			return curret_pointer[i];
		}
		return NULL;
	}
	T operator[](int id)const {
		if (id<=right_border){
			return current_pointer[id];
		}
		return NULL;
	}
	void insert(int a, T b){
		if (capacity==0){
			current_pointer = manager.giveEmptyMemory();
			capacity = 2;
		}
		if (right_border==capacity){
			current_pointer = manager.increaseMaxSize(current_pointer,capacity);
			capacity*=2;
		}
		if (a>capacity){
			while(a>capacity){
				current_pointer = manager.increaseMaxSize(current_pointer,right_border,capacity);
				capacity*=2;
			}
		}
		current_pointer[a] = b;
		stack.push(a);
		right_border = a+1;
	}
	T del(int a){
		if (stack.lastOf()==-1){
			throw "Array is empty";
		}
		if (a>capacity){
			throw "No such element";
		}
		T ret_value = current_pointer[a];
		current_pointer[a] = 0;
		stack.pop();
		if (stack.lastOf()*2<capacity&&stack.lastOf()!=-1&&capacity!=0){
			while((stack.lastOf()+1)*2<capacity){			
				capacity/=2;
			}
			current_pointer = manager.decreaseMaxSize(current_pointer,capacity);
		}
		right_border = stack.lastOf()+1;
		return ret_value;
	}
};