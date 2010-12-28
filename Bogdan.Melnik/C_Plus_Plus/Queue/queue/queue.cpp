
#ifndef _QUEUE_QUEUE_
#define _QUEUE_QUEUE_

#include <iostream>

template< class T >
struct Node {
  T elem;
  Node<T> *next;
};


template< class T,class A = std::allocator<T> > class Queue {
  private:    
    typedef Node<T> node;
    typedef T elem_type;
    typedef typename A::template rebind<node>::other node_alloc;  
    typedef A elem_alloc;
    static node_alloc _na;
    static elem_alloc _ea;
    node *_head, *_tail;
  public:
    Queue();
    virtual ~Queue();
    void push(elem_type i);
    bool isempty();
    elem_type shift();
    class QueueUnderflow {};
};


template< class T,class A > 
Queue<T,A>::Queue() {
  _head = 0;
  _tail = 0;
}

template< class T,class A > 
Queue<T,A>::~Queue() {
  while (!isempty()) 
    shift();
}

template< class T,class A > 
bool Queue<T,A>::isempty() {
  return (_head == 0 && _tail == 0);
}

template< class T,class A > 
void Queue<T,A>::push(T i) {
  if (_head == 0 && _tail == 0) {
    node *t = _na.allocate(1);
    _ea.construct(&t->elem,i);
    _head = t;
    _tail = t;
  } else {
    node *t = _na.allocate(1);
    _ea.construct(&t->elem,i);
    _tail->next = t;
    _tail = t;
  }
}

template< class T,class A > 
T Queue<T,A>::shift() {
  if (isempty()) {
    throw QueueUnderflow();
  }
  elem_type elem;
  if ( _head == _tail ) {
    elem = _head->elem;
    _ea.destroy(&_head->elem);
    _na.deallocate(_head,1);
    _head = _tail = 0;
  } else {
    node *t = _head->next;
    elem = _head->elem;
    _ea.destroy(&_head->elem);
    _na.deallocate(_head,1);
    _head = t;
  }
  return elem;
}

#endif
