
#ifndef _STACK_STACK_
#define _STACK_STACK_


template< class T,class Allocator = std::allocator<T> > class stack {
  private:
    struct node {
      T *elem;
      node *next;
    };
    node *current;
    Allocator *_a;
  public:
    stack();
    class StackUnderflow {};
    void push(T n);
    T pop();
    void debug() const;
    virtual ~stack();
};

template<class T,class Allocator> stack<T,Allocator>::stack() {
  current = 0;
  _a = new Allocator();
};

template<class T,class Allocator> stack<T,Allocator>::~stack() {
  if (_a) {
    delete _a;
  }
};

template<class T,class Allocator> void stack<T,Allocator>::push(T n) {  
  T *t = _a->allocate(1);
  _a->construct(t,n);  
  node *nd = new node();
  nd->elem = t;
  nd->next = current;
  current = nd;
};

template<class T,class Allocator> void stack<T,Allocator>::debug() const {  
  node *t = current;
  while (t != 0) {
    std::cout << *t->elem << std::endl;
    t = t->next;
  }
}

template<class T,class Allocator> T stack<T,Allocator>::pop() {  
  if (current == 0) {
    throw StackUnderflow();
  }
  node *t = current;
  current = t->next;
  T value = *t->elem;
  _a->destroy(t->elem);
  _a->deallocate(t->elem,1);
  delete t;
  return value;
}

#endif
