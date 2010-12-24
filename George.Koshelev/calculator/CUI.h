#include <cstring>
class CUI{
private:
	String myString;
public:
	CUI(){};
	~CUI(){
	myString = null;
	}
	void launch(){
		cout<<"Please enter the expression\n";
		cin>>myString;
	}
}