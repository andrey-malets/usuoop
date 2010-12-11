template <
	class T,
	class AllocPolicy = myAllocPolicy<>,
	class Allocator = SimpleAllocator<T>
>
class DynArray : private AllocPolicy, Allocator{
	typedef AllocPolicy policy;
private:
	size_t size;
	T * data;
public:
	DynArray(){
		size = policy::defaultSize;
		data = Allocator::allocate(size);
	}
	DynArray(size_t S):size(S){
		data = Allocator::allocate(S) ;
	}
	DynArray(const DynArray & rhs){
		size = rhs.size;
		data = Allocator::allocate(size);
		memcpy (data, rhs.data, rhs.size * sizeof(T));
	}
	~DynArray(){
		Allocator::deallocate(data);
		size = 0;
	}
	void growto(size_t Newsize){
		size_t newsize = policy::growSize(Newsize, size);
		T * data2 = Allocator::allocate(newsize);
		memcpy (data2, data, size * sizeof(T));
		Allocator::deallocate(data);
		data = data2;
		size = newsize;
	}
	size_t getSize(){
		return size();
	}
	T& operator[] (size_t i){
		if (i<size){
			return data[i];
		}
		growto(i+1);
		return data[i];
	}
	DynArray& operator = (const DynArray & rhs){
		if (*this == *rhs) return this;
		Allocator::deallocate(data);
		size = rhs.size;
		data = Allocator::allocate(size);;
		memcpy (data, rhs.data, rhs.size * sizeof(T));
		return this;
	}
};