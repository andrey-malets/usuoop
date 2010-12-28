
#ifndef _QUEUE_QUEUE_
#define _QUEUE_QUEUE_

#include <iostream>
#include <cstring>

template <size_t size,size_t min = 1>
class policy {
  public:
    size_t grow(size_t s,size_t c) {
      return s == 0 ? min : s > c ? s : s * size + 1;
    };
    size_t shrink(size_t s,size_t c) {
      if (c - s > 5)
        return c - 4;
      else
        return c;
    };
};

template< class T,class A = std::allocator<T>,class P = policy<2,10> > class Vector {
  private:    
    typedef T elem_type;
    typedef A elem_alloc;
    typedef P policy;
    elem_alloc _ea;
    elem_type *_pointer;
    size_t _size;
    size_t _capacity;
    policy _p;
    inline void change(size_t c);
  public:
    Vector();
    virtual ~Vector();
    void push(elem_type i);
    void pop();
    bool empty();
    size_t size();
    size_t capacity();
    elem_type front();
    elem_type back();
    elem_type operator[](const int& i);
    class VectorUnderflow {};
};


template< class T,class A, class P > 
Vector<T,A,P>::Vector() {
  _size = 0;
  _capacity = _p.grow(_size,0);
  _pointer = _ea.allocate(_capacity);
}

template< class T,class A, class P > 
Vector<T,A,P>::~Vector() {
  _ea.deallocate(_pointer,_size);
}

template< class T,class A, class P > 
inline void Vector<T,A,P>::change(size_t c) {
  elem_type *t = _ea.allocate(c);
  memcpy(t,_pointer,_size * sizeof(T));
  _ea.deallocate(_pointer,_size);
  _pointer = t;
}

template< class T,class A, class P > 
void Vector<T,A,P>::push(T i) {
  if (_size + 1 >= _capacity) {  
    _capacity = _p.grow(_size + 1,_capacity);
    change(_capacity);
  }
  _ea.construct(&_pointer[_size],i);
  _size++;
}

template< class T,class A, class P > 
void Vector<T,A,P>::pop() {
  if (empty()) {
    throw VectorUnderflow();
  }
  _size--;
  size_t shrink = _p.shrink(_size,_capacity);
  if ( shrink != _capacity && _size < shrink ) {
    change(shrink);
    _capacity = shrink;
  }
}

template< class T,class A, class P > 
T Vector<T,A,P>::operator[](const int& i) {
  return _pointer[i];
}

template< class T,class A, class P > 
size_t Vector<T,A,P>::size() {
  return _size;
}

template< class T,class A, class P > 
size_t Vector<T,A,P>::capacity() {
  return _capacity;
}

template< class T,class A, class P > 
T Vector<T,A,P>::front() {
  return _pointer[0];
}

template< class T,class A, class P > 
T Vector<T,A,P>::back() {
  return _pointer[_size - 1];
}

template< class T,class A, class P > 
bool Vector<T,A,P>::empty() {
  return _size == 0;
}

#endif
