#include <iostream>

#include "stack/stack.cpp"

int main () {
  Stack<int> stack;
  for (int i = 0; i < 10; ++i)
    stack.push(i);
  for (int i = 0; i < 10; ++i)
    std::cout << stack.pop() << std::endl;
  return 0;
}
