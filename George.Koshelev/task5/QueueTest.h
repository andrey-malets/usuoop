template<class T>
class TestQueue{
private:
Queue<T> queue;
void test1(){
	int k,n=3;
	k = rand()%n;
	queue.push(k);
	T a = queue.pop();
	if (a==k) std::cout<<"Test #1 compleated\n";
	else std::cout<<"Test #1 fail, explected "<<k<<" but was "<<a<<"\n";
}
void test2(){
	int m,k,n=3;
	k = rand()%n;
	m = rand()%n;
	queue.push(k);
	queue.push(m);
	T a = queue.pop();
	a = queue.pop();
	if (a==m) std::cout<<"Test #2 compleated\n";
	else std::cout<<"Test #2 fail, explected "<<m<<" but was "<<a<<"\n";
}
void test3(){
	queue.push(1);
	queue.push(2);
	queue.pop();
	queue.pop();
	queue.push(31337);
	queue.push(31337);
	T a = queue.pop();
	a+=queue.pop();
	if (a==(31337*2)) std::cout<<"Test #3 compleated\n";
	else std::cout<<"Test #3 fail, explected "<<31337*2<<" but was "<<a<<"\n";
}
public:
	TestQueue(){};
	~TestQueue(){};
	void startTest(){
		test1();
		test2();
		test3();
	}
};