#include "Queue.h"
#include <iostream>

using namespace std;

int main(){
	Queue<int> q;
	
	int ival;
	for (ival = 0; ival < 10; ++ival)
		q.add(ival);
	int err_cnt = 0;
	for (ival = 0; ival < 10; ++ival){
		int qval = q.remove();
		if (ival != qval) err_cnt++;
	}
	if (!err_cnt)
		cout<<"!queue executed ok!\n";
	else cerr<<"??queue errors"<<err_cnt<<endl;
	
	return 0;
}