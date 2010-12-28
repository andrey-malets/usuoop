#include <iostream>
#include <vector>
#include "vector/vector.cpp"

using namespace std;

int main() {
  Vector<int> v;
  for (int i = 0; i < 1024; ++i) 
    v.push(i);
  for (int i = 0; i < 1024; ++i) {
    v.pop();
  }
  return 0;
}
