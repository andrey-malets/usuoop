#include <vector>
#include <iostream>
using namespace std;
template <class X>
class Vector2D{
private :
	vector<X> comp;
public :
	Vector2D(X a,X b){
		comp.push_back(a);
		comp.push_back(b);
	}

	X getComp(int i){
		if (i<0||i>2){
		throw "Wrong index";
		}
		return comp[i];
	}
	X scalar(Vector2D<X> a){
		X q;
		for (int i=0;i<2;i++){
		q=q+(comp[i]*a.getComp(i));	
		}
	return q;
	}
	X len(){
		Integer q;
		for(unsigned int i=0;i<comp.size();i++){
			q = q+(comp[i]*comp[i]);
		}
		return q;
	}
	int getDimension(){
		return comp.size();
	}
};