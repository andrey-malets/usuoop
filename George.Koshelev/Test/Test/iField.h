//#include "IntegerField.h"
//#include "BinField.h"
//#include "DoubleField.h"
class iField{
public:
	iField operator =(iField x);
	iField operator +(iField x);
	iField operator -(int);
	iField operator *(iField);
	iField operator /(int);
};