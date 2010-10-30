/*
 * A.h
 *
 *  Created on: 31.10.2010
 *      Author: ld
 */

#ifndef A_H_
#define A_H_

#include <iostream>

class A {
 private:
  int _n;
 public:
  A(int);
  void show();
};

A::A(int n) {
  this->_n = n;
}

void A::show() {
  std::cout << _n << std::endl;
}

#endif /* A_H_ */
