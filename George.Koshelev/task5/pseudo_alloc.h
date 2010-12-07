template<class T>
class Allocator{
public:
	Allocator(){};
	~Allocator(){};
	T* giveMemory(int size){
		return (T*) new T[size]; 
	}
	void freeMemory(T* pointer){
		delete []pointer;
	}
};