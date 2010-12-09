
#ifndef _STACK_STACK_
#define _STACK_STACK_

#include <iostream>

template< class T >
struct Node {
  T elem;
  Node<T> *next;
};


template< class T,class A = std::allocator<T> > class Stack {
  private:    
    typedef Node<T> node;
    typedef T elem_type;
    typedef typename A::template rebind<node>::other node_alloc;  
    typedef A elem_alloc;
    node_alloc _na;
    elem_alloc _ea;
    node *_top;
  public:
    Stack();
    virtual ~Stack();
    void debug();
    void push(elem_type i);
    bool isempty();
    elem_type pop();
    class StackUnderflow {};
};


template< class T,class A > 
Stack<T,A>::Stack() {
  _top = 0;
}

template< class T,class A > 
Stack<T,A>::~Stack() {
  while (!isempty()) 
    pop();
}

template< class T,class A > 
bool Stack<T,A>::isempty() {
  return (_top == 0);
}

template< class T,class A > 
void Stack<T,A>::push(T i) {
  node *t = _top;
  _top = _na.allocate(1);
  _ea.construct(&t->elem,i);
  _top->next = t;
}

template< class T,class A > 
T Stack<T,A>::pop() { 
  if (isempty()) {
    throw StackUnderflow();
  }
  node *t = _top->next;
  elem_type elem = _top->elem;
  _ea.destroy(&_top->elem);
  _na.deallocate(_top,1);
  _top = t;
  return elem;
}

#endif
