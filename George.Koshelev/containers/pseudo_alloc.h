template<class T,int pol>
class Pseudo_Alloc{
private:
	int policy;
public:
	Pseudo_Alloc(){
		policy = pol;
	}
	T* giveMemory(){
		T* pointer = new T[policy];
		return pointer;
	}
	T* addMemory(T* ipointer,int a){
		T * pointer = new T[a*policy];
		for (int i=0;i<a;i++){
			pointer[i] = ipointer[i];
		}
		return pointer;
	}
	T* addMemory_queue(T*ipointer,int a){
		T* pointer = new T[a*policy];
		for (int i=0;i<a;i++){
			pointer[policy+i] = ipointer[i];
		}
		return pointer;
	}
	T* reduceMemory(T* ipointer, int a){
		T* pointer = new T[a];
		for (int i=0;i<a;i++){
			pointer[i] = ipointer[i];
		}
		delete []ipointer;
		return pointer;
	}
};