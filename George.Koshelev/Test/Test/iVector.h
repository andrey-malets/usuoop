#include "Vector2D.h"
#include <vector>
#include "iField.h"
template<class X>
class iVector{
public :
	virtual X getComp(int)=0;
	virtual X scalar(iVector<X>)=0;
	virtual X len()=0;
	virtual int getDimension()=0;
};