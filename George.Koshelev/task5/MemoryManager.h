#include "pseudo_alloc.h"
template <class T,int pol>
class MemoryManager{
private:
	int policy;
	Allocator<T> al;
public:
	MemoryManager():policy(pol){};
	~MemoryManager(){};	
	T* increaseMaxSize(T*pointer,int right_border){
		T* new_pointer = al.giveMemory(right_border*policy);
		for (int i=0;i<right_border;i++){
			new_pointer[i] = pointer[i];
		}
		al.freeMemory(pointer);
		return new_pointer;
	}
	T* increaseMaxSize(T*pointer,int right_border, int capacity){
		T* new_pointer = al.giveMemory(capacity*policy);
		for (int i=0;i<right_border;i++){
			new_pointer[i] = pointer[i];
		}
		al.freeMemory(pointer);
		return new_pointer;
	}
	T* decreaseMaxSize(T* pointer,int right_border){
		T* new_pointer = al.giveMemory(right_border);
		for (int i=0;i<right_border;i++){
			new_pointer[i] = pointer[i];
		}
		al.freeMemory(pointer);
		return new_pointer;
	}
	T* giveEmptyMemory(){
		T* new_pointer = al.giveMemory(policy);
		return new_pointer;
	}
	void freeMemory(T* pointer){
		al.freeMemory(pointer);
	}
};