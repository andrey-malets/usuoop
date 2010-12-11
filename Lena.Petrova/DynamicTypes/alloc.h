template <class T> struct SimpleAllocator{
public:
	T * allocate(size_t size){
		if (size > 0){
			return new T[size];
		}
		throw std::bad_alloc();
	}
	void deallocate (T * pointer){
		delete [] pointer;
	}
};

template <size_t DS = 4>struct myAllocPolicy{
public:
	static const size_t defaultSize = DS;
	size_t growSize(size_t desiredSize, size_t curSize){
		return (desiredSize > curSize*2)?desiredSize:(curSize*2 + 1);
	}
	size_t shrinkSize(size_t desiredSize, size_t curSize){
		return (desiredSize >= curSize)?curSize:(desiredSize > defaultSize)?desiredSize:defaultSize;
	}
};

struct hisAllocPolicy{
public:
	static const size_t defaultSize = 40;
	size_t growSize(size_t desiredSize, size_t curSize){
		return (desiredSize > curSize*2)?desiredSize:(curSize*2 + 1);
	}
	size_t shrinkSize(size_t desiredSize, size_t curSize){
		return (desiredSize >= curSize)?curSize:(desiredSize > defaultSize)?desiredSize:defaultSize;
	}
};