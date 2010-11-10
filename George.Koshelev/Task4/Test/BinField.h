class Binary{
public:
	int a;
	Binary(int x){
		if (x>1||x<0){
			throw "Exception: wrong ";
		}
		a = x;
	}
	Binary(){
		a = 0;
	}
	Binary operator =(Binary x){
		this->a = x.get();
		return *this;
	}
	Binary operator +(Binary x){
		return Binary((a+x.get())%2);
	}
	Binary operator -(Binary x){
		return Binary(a-x.get());
	}
	Binary operator *(Binary x){
		return Binary(a*x.get());
	}
	Binary operator /(Binary x){
		if (x.get()==0){
		throw "Division by zero";
		}
		return Binary(a/x.get());
	}
	int get(){
		return this->a;
	}
};