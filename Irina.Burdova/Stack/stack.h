#include <exception>
#include <algorithm>
#include <string>

#ifndef STACK_H
#define STACK_H

using std::allocator;

template<class Type, class Allocator = allocator<Type> >
class Stack{
public:
	Stack(const Allocator& = Allocator());
	Stack(unsigned int, const Allocator& = Allocator());
	~Stack();

	void push(Type&);
	Type& pop();
	unsigned int capacity();
	unsigned int size();

private:
	Type *arr;
	Allocator alloc;
	unsigned int dimension;
	unsigned int top;
	void setSize(unsigned int);
};

class StackException : public std::exception{
public:
	StackException();
	StackException(std::string m) : message(m) {};
	StackException(const char* m) : message(m) {};
	std::string getMessage() { return message; };
	~StackException() {};
	virtual const char* what() const throw() { return message.c_str(); }
private:
	std::string message;
};

template<class Type, class Allocator>
Stack<Type, Allocator>::Stack(const Allocator& a) : dimension(10), top(-1), alloc(a){
	arr = alloc.allocate(10);
}

template<class Type, class Allocator>
Stack<Type, Allocator>::Stack(unsigned int size, const Allocator& a) : dimension(size), top(-1), alloc(a){
	arr = alloc.allocate(size);
}

template<class Type, class Allocator>
Stack<Type, Allocator>::~Stack(){
	for(int i = 0; i != dimension; ++i)
		alloc.destroy(&arr[i]);
	alloc.deallocate(arr, dimension);
}

template<class Type, class Allocator>
unsigned int Stack<Type, Allocator>::capacity(){
	return dimension;
}

template<class Type, class Allocator>
unsigned int Stack<Type, Allocator>::size(){
	return top + 1;
}

template<class Type, class Allocator>
void Stack<Type, Allocator>::push(Type& el){
	if (top + 2 > dimension){
		setSize(dimension * 2);
	}
	alloc.construct(&arr[++top], el);
}

template<class Type, class Allocator>
Type& Stack<Type, Allocator>::pop(){
	if (top == -1){
		throw new StackException("Pop from empty stack");
	}
	Type t = arr[top];
	alloc.destroy(&arr[top--]);
	return t;
}

template<class Type, class Allocator>
void Stack<Type, Allocator>::setSize(unsigned int nsize){
	try{
		Type *tmp = alloc.allocate(nsize);
		std::uninitialized_copy(arr, arr+dimension, tmp);
		std::uninitialized_fill(tmp+dimension, tmp+nsize, Type());
		for(int i = 0; i != dimension; ++i)
			alloc.destroy(&arr[i]);
		alloc.deallocate(arr, dimension);
		arr = tmp;
		dimension = nsize;
	}
	catch(std::bad_alloc& e){
		throw new StackException(e.what());
	}
}

#endif
