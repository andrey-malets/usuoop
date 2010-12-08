
#ifndef _STACK_STACK_
#define _STACK_STACK

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
    node *top;
  public:
    Stack();
    void debug();
    void push(elem_type i);
    elem_type pop();
    class StackUnderflow {};
};


template< class T,class A > 
Stack<T,A>::Stack() {
  this->top = 0;
}

template< class T,class A > 
void Stack<T,A>::push(T i) {
  node *t = top;
  top = _na.allocate(1);
  _ea.construct(&t->elem,i);
  top->next = t;
}

template< class T,class A > 
T Stack<T,A>::pop() { 
  if (!top) {
    throw StackUnderflow();
  }
  node *t = top->next;
  elem_type elem = top->elem;
  _ea.destroy(&top->elem);
  _na.deallocate(top,1);
  top = t;
  return elem;
}

template< class T,class A > 
void Stack<T,A>::debug() {
  node *t = top;
  while (t) {
    std::cout << t->elem << std::endl;
    t = t->next;
  }
}
#endif
