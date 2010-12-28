#include <iostream>
#include <cstdlib>
#include <exception>
#ifndef QUEUE_H
#define QUEUE_H

template <class Type> struct QueueItem{
	Type item;
	QueueItem *next;
};

template <class Type, class Allocator = std::allocator<QueueItem<Type> > > class Queue
{
public:
	Queue(const Allocator& al = Allocator()) : front(NULL), back(NULL) { a = al; };
	~Queue();

	Type remove();
	void add(const Type &);

	bool is_empty() const{
		return front == 0;
	}

private:
	QueueItem<Type> *front;
	QueueItem<Type> *back;
	Allocator a;
};

template <class Type, class Allocator>
Queue<Type,Allocator>::~Queue(){
	while (!is_empty())
		deallocat();
}

template <class Type, class Allocator>
void Queue<Type,Allocator>::add(const Type &val){
	QueueItem<Type> *pt = a.allocate(1);
	pt->item = val;
	if(is_empty()) 
	{
		front = back = pt;
	}
	else
	{
		back->next = pt;
		back = pt;
	}
}

template <class Type, class Allocator>
Type Queue<Type,Allocator>::remove(){
	if (is_empty())
		throw my_error("FATAL ERROR"); 

	QueueItem<Type> *pt = front;
	Type retval = pt->item;
	front = front->next;
	a.destroy(pt);
	a.deallocate(pt, 1);
	return retval;
}


class my_error: public std::exception {
private:
        const char *m_err;
public:
        my_error(const char *err) throw() : m_err(err) {}
        ~my_error() throw() {}
        virtual const char* what() const throw() { return m_err; }
};


#endif QUEUE_H
