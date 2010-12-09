#include <iostream>

#include "stack/stack.cpp"

int main () {
  Stack<int> stack;
  for (int i = 0; i < 100; ++i)
    stack.push(i);
  return 0;
}
