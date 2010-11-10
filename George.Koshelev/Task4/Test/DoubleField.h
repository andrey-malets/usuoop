class Real{
public:
	double a;
	Real(double x){
		a = x;
	}
	Real(){
		a = 0;
	}
	Real operator =(Real x){
		this->a = x.get();
		return *this;
	}
	Real operator +(Real x){
		return Real(a+x.get());
	}
	Real operator -(Real x){
		return Real(a-x.get());
	}
	Real operator *(Real x){
		return Real(a*x.get());
	}
	Real operator /(Real x){
		if (x.get()==0){
			throw "Divixion by zero";
		}
		return Real(a/x.get());
	}
	double get(){
		return this->a;
	}
};