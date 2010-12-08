template <class T>
class TestArray{
private:
	Array<T> arr;
	void test1(){
		T k,n=3;
		k = rand()%n;
		arr.insert(0,k-1);
		arr.insert(1,k);
		T ret1 = arr.del(1);
		ret1+= arr.del(0);
		if (ret1==2*k-1) std::cout<<"Test #1 complete\n";
		else std::cout<<"Test #1 fail, expected "<<2*k-1<<" but was "<<ret1<<"\n";
	}
	void test2(){
		T sum = 0;
		T sum_arr=0;
		for (int i=0;i<50;i++){
			arr.insert(i,i);
			sum+=i;
		}
		for (int i=49;i>0;i--){
			sum_arr+=arr.del(i);
		}
	if (sum==sum_arr) std::cout<<"Test #2 complete\n";
	else std::cout<<"Test #2 fail, expected "<<sum<<" but was "<<sum_arr<<"\n";
	}
	void test3(){
		T sum = 0;
		T sum_arr=0;
		for (int i=0;i<50;i++){
			arr.insert(i,i);
			sum+=i;
		}
		for (int i=49;i>=0;i--){
			sum_arr+=arr.del(i);
		}
		for (int i=0;i<50;i++){
			arr.insert(i,i+1);
			sum+=(i+1);
		}
		for (int i=49;i>=0;i--){
			sum_arr+=arr.del(i);
		}
	if (sum==sum_arr) std::cout<<"Test #3 complete\n";
	else std::cout<<"Test #3 fail, expected "<<sum<<" but was "<<sum_arr<<"\n";
	}

public:
	TestArray(){};
	~TestArray(){};
	void startTest(){
		test1();
		test2();
		test3();
	}
};