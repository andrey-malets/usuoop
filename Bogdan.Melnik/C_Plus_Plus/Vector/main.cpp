#include <iostream>
#include <vector>
#include <algorithm>
#include "vector/vector.h"

using namespace std;

int main() {
  Vector<int> v;

  for (int i = 0; i < 50; ++i) {
    v.push(i);
  }

  reverse(v.begin(),v.end());

  for_each (v.begin(), v.end(), [] (int x)  { cout << x << endl;  });

  return 0;
}
