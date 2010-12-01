#include <iostream>

#include "stack/stack.cpp"

int main () {
  stack<int> a;
  for (int i = 0; i < 10;++i)
    a.push(i);
  for (int i = 0; i < 10;++i) 
    std::cout << a.pop() << std::endl;
  return 0;
}
