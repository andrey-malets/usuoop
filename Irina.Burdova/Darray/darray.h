#include <exception>
#include <algorithm>
#include <string>

#ifndef DARRAY_H
#define DARRAY_H

using std::allocator;

template<class Type, class Allocator = allocator<Type> >
class DArray{
public:
	DArray(const Allocator& = Allocator());
	DArray(unsigned int, const Allocator& = Allocator());
	DArray(unsigned int, Type&, const Allocator& = Allocator());
	~DArray();

	typename Type& operator[](unsigned int);
	size_t size();
	void setSize(unsigned int);

private:
	Type *arr;
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

template<class Type, class Allocator>
DArray<Type, Allocator>::DArray(const Allocator& a) : dimension(0), alloc(a){
}

template<class Type, class Allocator>
DArray<Type, Allocator>::DArray(unsigned int size, const Allocator& a) : dimension(size), alloc(a){
	arr = alloc.allocate(size);
}

template<class Type, class Allocator>
DArray<Type, Allocator>::DArray(unsigned int size, Type& def, const Allocator& a) : dimension(size), alloc(a){
	arr = alloc.allocate(size);
	for (int i = 0; i != size; ++i){
		alloc.construct(&arr[i], def);
	}
}

template<class Type, class Allocator>
DArray<Type, Allocator>::~DArray(){
	for(int i = 0; i != dimension; ++i)
		alloc.destroy(&arr[i]);
	alloc.deallocate(arr, dimension);
}

template<class Type, class Allocator>
typename Type& DArray<Type, Allocator>::operator[](unsigned int idx){
	////if (idx < 0){
	////	throw new DArrayException("Illegual index");
	////}
	//if (idx > dimension){
	//	unsigned int nsize = 2 * dimension;
	//	if (idx > nsize)
	//		nsize = idx+1;
	//	setSize(nsize);
	//}
	return arr[idx];
}

template<class Type, class Allocator>
size_t DArray<Type, Allocator>::size()
{
	return dimension;
}

template<class Type, class Allocator>
void  DArray<Type, Allocator>::setSize(unsigned int nsize){
	try{
		Type *tmp = alloc.allocate(nsize);
		std::uninitialized_copy(arr, arr+dimension, tmp);
		std::uninitialized_fill(tmp+dimension, tmp+nsize, Type());
		for(int i = 0; i != dimension; ++i)
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
