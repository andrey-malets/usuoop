#include "MemoryManager.h"
template<class T> 
class Queue{	
private:
	struct q{
		T *value;
		q *next;
	};
	q *current;
	q *begin;
	int total_numb;
	MemoryManager<T,1> manager;
public:
	Queue(){
		total_numb = 0;
		current = 0;
		begin = 0;
	};
	~Queue() {};
	void push(T pushValue){
		T *free_space = manager.giveEmptyMemory();
		*free_space = pushValue;
		q * vert = new q();
		vert->value = free_space;
		if (total_numb==0){
			begin = vert;
			current = vert;
			vert->next = 0;
		}
		else{
			current->next = vert;
			vert->next = 0;
			current = vert;
		}
		total_numb++;
	}
	T pop(){
		if (total_numb == 0) {
			throw "Queue is empty\n";
		}
		total_numb--;
		q *temp = begin;
		begin = temp->next;
		T val = *temp->value;
		manager.freeMemory(temp->value);
		delete temp;
		return val;
	}
};