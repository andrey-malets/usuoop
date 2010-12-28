#include <iostream>
#include <vector>
#include "vector/vector.cpp"

using namespace std;

int main() {
  Vector<int> v;
  for (int i = 5; i < 10; ++i) {
    v.insert(0,i);
    cout << v.size() << " " << v.capacity() << " - " << v.front() << endl;
  }
  cout << "Ho!" << endl;
  for (int i = 5; i < 10; ++i) {
    cout << v.size() << " " << v.capacity() << " - " << v.front() << endl;
    v.erase(0);
  }
  return 0;
}
