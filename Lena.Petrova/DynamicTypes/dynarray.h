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
	//constructors
	DynArray(): size(policy::defaultSize), data(Allocator::allocate(size)){	}
	DynArray(size_t S): size(S), data(Allocator::allocate(S)){ }
	DynArray(const DynArray & rhs): size(rhs.size), data(Allocator::allocate(size)) {
		memcpy (data, rhs.data, rhs.size * sizeof(T));
	}
	template <class newpolicy> DynArray(const DynArray<T, newpolicy, Allocator> & rhs): size(rhs.getSize()), data (Allocator::allocate(size)){
		memcpy (data, rhs.getData(*this), (idx + 1) * sizeof(T));
	}

	//destructor
	~DynArray(){
		Allocator::deallocate(data);
		size = 0;
	}

	//special functions
	void growto(size_t Newsize){
		size_t newsize = policy::growSize(Newsize, size);
		T * data2 = Allocator::allocate(newsize);
		memcpy (data2, data, size * sizeof(T));
		Allocator::deallocate(data);
		data = data2;
		size = newsize;
	}

	size_t getSize() const {
		return size();
	}

	template<class newpolicy> const T * const getData(const DynArray<T, newpolicy, Allocator> &) const
	{
		return data;
	}
	
	T& operator[] (size_t i){
		if (i<size){
			return data[i];
		}
		growto(i+1);
		return data[i];
	}

	template <class p> bool operator == (const DynArray<T,p,Allocator> &rhs)
	{
		if (size!=rhs.getSize()) return false;
		const T * rhsData = rhs.getData(*this);
		for (size_t i=0; i<size; ++i) {
			if (rhsData[i] != data[i]) return false;
		}
		return true;
	}

	DynArray& operator = (const DynArray & rhs){
		if (*this == rhs) return *this;
		Allocator::deallocate(data);
		size = rhs.size;
		data = Allocator::allocate(size);;
		memcpy (data, rhs.data, rhs.size * sizeof(T));
		return *this;
	}

	template <class newpolicy> DynArray& operator= (const DynArray<T, newpolicy, Allocator> & rhs){
		if (*this == rhs) return *this;
		Allocator::deallocate(data);
		size = rhs.getSize();
		data = Allocator::allocate(size);
		memcpy (data, rhs.getData(*this), (rhs.getIdx() + 1) * sizeof(T));
		idx = rhs.getIdx();
		return *this;
	}
};