#include <iostream>
#include <vector>
#include <algorithm>
#include "vector/vector.h"

using namespace std;

template<class C, class F> void for_each(const C &c, const F &f) { for_each(c.begin(), c.end(), f); }
template<class C, class F> void for_each(C &c, const F &f) { for_each(c.begin(), c.end(), f); }

int main() {
	Vector<int> v;

	for (int i = 0; i < 50; ++i) {
		v.push(i);
	}

	reverse(v.begin(),v.end());
	sort(v.begin(), v.end());

	for_each (v, [] (int x) { cout << x << endl; });

	return 0;
}
