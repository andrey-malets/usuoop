template<class T>
class Allocator{
public:
	Allocator(){};
	~Allocator(){};
	T* giveMemory(int policy){
		T* pointer = new T[policy];
		return pointer;
	}
	T* giveMemory(){
		return (T*)new T;
	}
	void delMemory(T* a){
		delete a;
	}
	T* addMemory(T* ipointer,int prev_size,int policy){
		T * pointer = new T[prev_size*policy];
		for (int i=0;i<prev_size;i++){
			pointer[i] = ipointer[i];
		}
		return pointer;
	}
	T* reduceMemory(T* ipointer, int new_border){
		T* pointer = new T[new_border];
		for (int i=0;i<new_border;i++){
			pointer[i] = ipointer[i];
		}
		delete []ipointer;
		return pointer;
	}
};