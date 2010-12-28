
#ifndef _VECTOR_VECTOR_
#define _VECTOR_VECTOR_

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
    bool empty() const;
    size_t size() const;
    size_t capacity() const;
    void insert(const size_t& i,elem_type e);
    void erase(const size_t& i);
    elem_type front() const;
    elem_type back() const;
    elem_type operator[](const size_t& i) const;
    class VectorUnderflowException {};
    class InvalidRangeInsertException {};
    class OutOfRangeException {};
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
    throw VectorUnderflowException();
  }
  _size--;
  size_t shrink = _p.shrink(_size,_capacity);
  if ( shrink != _capacity && _size < shrink ) {
    change(shrink);
    _capacity = shrink;
  }
}

template< class T,class A, class P > 
T Vector<T,A,P>::operator[](const size_t& i) const {
  if (i +1 > _size)
    throw OutOfRangeException();
  return _pointer[i];
}

template< class T,class A, class P > 
size_t Vector<T,A,P>::size() const {
  return _size;
}

template< class T,class A, class P > 
size_t Vector<T,A,P>::capacity() const {
  return _capacity;
}

template< class T,class A, class P > 
T Vector<T,A,P>::front() const {
  return (*this)[0];
}

template< class T,class A, class P > 
T Vector<T,A,P>::back() const {
  return (*this)[_size - 1];
}

template< class T,class A, class P > 
bool Vector<T,A,P>::empty() const {
  return _size == 0;
}

template< class T,class A, class P > 
void Vector<T,A,P>::insert(const size_t& i,T e) {
  if (i > _size + 1) 
    throw InvalidRangeInsertException();
  if (_size + 1 >= _capacity) {  
    _capacity = _p.grow(_size + 1,_capacity);
    change(_capacity);
  }
  memcpy(&_pointer[i+1],&_pointer[i],(_size - i) * sizeof(T)); // WTF?! its work!
  _ea.construct(&_pointer[i],e);
  _size++;
}

template< class T,class A, class P > 
void Vector<T,A,P>::erase(const size_t& i) {
  memcpy(&_pointer[i],&_pointer[i + 1],(_size - i) * sizeof(T));  
  _size--;
}

#endif
