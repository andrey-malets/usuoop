#include <iostream>
#include <vector>
#include "vector/vector.cpp"

using namespace std;

int main() {
  Vector<int> v;
  v.insert(0,1);
  v.insert(1,2);
  v.insert(1,3);
  v.erase(0);
  v.erase(0);
  cout << v[0] << endl;
  return 0;
}
