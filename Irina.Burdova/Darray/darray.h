#include <exception>
#include <algorithm>
#include <string>

#ifndef DARRAY_H
#define DARRAY_H

using std::allocator;


struct myPolicy{
public:
	size_t getGrowSize(size_t idx, size_t dimension){
		size_t nsize = dimension;
		if (idx > dimension){
			nsize = 2 * dimension;
			if (idx >= nsize)
				nsize = idx+1;
		}
		return nsize;
	}
};

template<class Type, class Policy = myPolicy, class Allocator = allocator<Type> >
class DArray: private Policy{
public:
	DArray();
	DArray(size_t);
	DArray(size_t, Type&);
	~DArray();

	typename Type& operator[](size_t);
	size_t size();
	void setSize(size_t);

private:
	Type *arr;
	Policy policy;
	Allocator alloc;
	size_t dimension;
};

class DArrayException : public std::exception{
public:
	DArrayException();
	DArrayException(std::string m) : message(m) {};
	DArrayException(const char* m) : message(m) {};
	std::string getMessage() { return message; };
	~DArrayException() {};
	virtual const char* what() const throw() { return message.c_str(); }
private:
	std::string message;
};

template<class Type, class Policy, class Allocator>
DArray<Type, Policy, Allocator>::DArray() : dimension(0), alloc(Allocator()){
}

template<class Type, class Policy, class Allocator>
DArray<Type, Policy, Allocator>::DArray(size_t size) : dimension(size), alloc(Allocator()){
	arr = alloc.allocate(size);
}

template<class Type, class Policy, class Allocator>
DArray<Type, Policy, Allocator>::DArray(size_t size, Type& def) : dimension(size), alloc(Allocator()){
	arr = alloc.allocate(size);
	for (size_t i = 0; i != size; ++i){
		alloc.construct(&arr[i], def);
	}
}

template<class Type, class Policy, class Allocator>
DArray<Type, Policy, Allocator>::~DArray(){
	for(size_t i = 0; i != dimension; ++i)
		alloc.destroy(&arr[i]);
	alloc.deallocate(arr, dimension);
}

template<class Type, class Policy, class Allocator>
typename Type& DArray<Type, Policy, Allocator>::operator[](size_t idx){
	size_t nsize = policy.getGrowSize(idx,dimension);
	setSize(nsize);
	return arr[idx];
}

template<class Type, class Policy, class Allocator>
size_t DArray<Type, Policy, Allocator>::size(){
	return dimension;
}

template<class Type, class Policy, class Allocator>
void  DArray<Type, Policy, Allocator>::setSize(size_t nsize){
	try{
		Type *tmp = alloc.allocate(nsize);
		std::uninitialized_copy(arr, arr+dimension, tmp);
		std::uninitialized_fill(tmp+dimension, tmp+nsize, Type());
		for(size_t i = 0; i != dimension; ++i)
			alloc.destroy(&arr[i]);
		alloc.deallocate(arr, dimension);
		arr = tmp;
		dimension = nsize;
	}
	catch(std::bad_alloc& e){
		throw new DArrayException(e.what());
	}
}

#endif
