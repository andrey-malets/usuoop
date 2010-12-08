template<class T,int a>
class TestStack{
private:
Stack<T,a> stack;
void test1(){
	int k,n=7;
	k = rand()%n;
	stack.push(k);
	T t1 = stack.pop();
	if (t1==k) std::cout<<"Test #1 compleated\n";
	else std::cout<<"Test #1 not compleated, expexted "<<k<<" but was "<<t1<<"\n";
	}
void test2(){
	int k,n=7;
	k = rand()%n;
	stack.push(k);
	stack.push(n);
	T t1 = stack.pop();
	t1+= stack.pop();
	if (t1==k+n) std::cout<<"Test #2 compleated\n";
	else std::cout<<"Test #2 not compleated, expexted "<<k+n<<" but was "<<t1<<"\n";
	}
void test3(){
	int k,n=7;
	k = rand()%n;
	stack.push(k);
	stack.push(n);
	stack.pop();
	stack.pop();
	stack.push(n);
	stack.push(k);
	T t1 = stack.pop();
	stack.pop();
	if (t1==k) std::cout<<"Test #3 compleated\n";
	else std::cout<<"Test #3 not compleated, expexted "<<k<<" but was "<<t1<<"\n";
}
void test4(){
	T max = 5050;
	T sum = 0;
	for (int i=0;i<100;i++){
		stack.push(i);
		if (i%2==0){
			sum+=i;
		}
	}
	max-=sum;
	T qwer;
	for (int i=99;i>0;i--){
		qwer = stack.pop();
		if (i%2!=0){
			max-=qwer;
		}
	}
	if (max==100) std::cout<<"Test #4 compleated\n";
	else std::cout<<"Test #4 not compleated, expexted "<<100<<" but was "<<max<<"\n";
}
public:
	TestStack(){};
	~TestStack(){};
	void startTest(){
		test1();
		test2();
		test3();
		test4();
	}

};