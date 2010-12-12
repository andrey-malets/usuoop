template <
	class T,
	class AllocPolicy = myAllocPolicy<>,
	class Allocator = SimpleAllocator<T>
>
class Stack : private AllocPolicy, Allocator {
	typedef AllocPolicy policy;
public:
	Stack(size_t S):size(S), idx(0), data(Allocator::allocate(S)) { }
	
	Stack():idx(0), size(policy::defaultSize), data(Allocator::allocate(size)) { }
	
	template <class newpolicy> Stack(const Stack<T, newpolicy, Allocator> & rhs){
		size = rhs.getSize();
		idx = rhs.getIdx();
		data = Allocator::allocate(size);
		memcpy (data, rhs.getData(*this), (idx + 1) * sizeof(T));
	}
	
	Stack(const Stack & rhs){
		size = rhs.size;
		idx = rhs.idx;
		data = Allocator::allocate(size);
		memcpy (data, rhs.data, (idx + 1) * sizeof(T));
	}
	
	template <class newpolicy> Stack& operator= (const Stack<T, newpolicy, Allocator> & rhs){
		if (*this == rhs) return *this;
		
		Allocator::deallocate(data);
		size = rhs.getSize();
		data = Allocator::allocate(size);
		memcpy (data, rhs.getData(*this), (rhs.getIdx() + 1) * sizeof(T));
		idx = rhs.getIdx();
		return *this;
	}
	
	template <class p> bool operator == (const Stack<T,p,Allocator> &rhs)
	{
		if (idx!=rhs.getIdx()) return false;
		const T * rhsData = rhs.getData(*this);
		for (size_t i=0; i<idx; ++i) {
			if (rhsData[i] != data[i]) return false;
		}
		return true;
	}
	
	void push (const T &o){
		if (idx+1>=size) grow(idx+2);
		data[idx++]=o;
	}
	T pop (){
		if (idx != 0) return data[--idx];
		throw exception("Stack is empty!\n");
	}
	
	template<class newpolicy> const T * const getData(const Stack<T, newpolicy, Allocator> &) const
	{
		return data;
	}
	
	size_t getSize() const { return size; }
	size_t getIdx() const { return idx; }

	~Stack(){
		Allocator::deallocate(data);
		size = idx = 0;
	}

private:
	size_t size;
	size_t idx;
	T * data;
	void grow (size_t Newsize){
		size_t newsize = policy::growSize(Newsize, size);
		T * data2 = Allocator::allocate(newsize);
		memcpy (data2, data, size * sizeof(T));
		Allocator::deallocate(data);
		data = data2;
		size = newsize;
	}
};