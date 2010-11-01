class Integer{
public:
	int a;
	Integer(int x){
		a = x;
	}
	Integer(){
		a = 0;
	}
	Integer operator =(Integer x){
		this->a = x.get();
		return *this;
	}
	Integer operator +(Integer x){
		return Integer(a+x.get());
	}
	Integer operator -(Integer x){
		return Integer(a-x.get());
	}
	Integer operator *(Integer x){
		return Integer(a*x.get());
	}
	Integer operator /(Integer x){
		if (x.get()==0){
		throw "Division by zero";
		}
		return Integer(a/x.get());
	}
	int get(){
		return this->a;
	}
};