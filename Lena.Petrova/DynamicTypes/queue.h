template <class T> struct Rec {
	T first;
	Rec<T> * second;
};

template <class T> class myQueue {
	typedef std::pair<T, std::pair<T, T *> *> a;
	typedef std::pair<T, a *> record;
	typedef Rec<T> rec;
private:
	rec * start;
	rec * end;
	void clean(){
		while (start){
			rec * temp = start;
			start = (start->second);
			delete temp;
		}
	}
public:
	myQueue():start(0), end(0){};
	~myQueue(){
		clean();
	}
	myQueue(const myQueue & rhs){
		if (rhs.start){
			rec * i = rhs.start->second;
			rec element = * start;
			rec * prev = start = new rec(element);			
			while (i) {
				element = new rec(*i);
				(prev->second) = element;
				i = i->second;
				prev = *element;
			}
			end = prev;
		}

	}
	myQueue & operator = (const myQueue & rhs){
		if (*this == *rhs) return this;
		clean();
		return myQueue<T>(rhs);
	}
	void add (const T &inf){
		rec *element = new rec();
		element->first = inf;
		element->second = 0;
		if (end){
			(end->second) = element;
		} else{
			start = element;
		}
		end = element;
	}
	T get(){
		if (start){
			T res = (start->first);
			rec * temp = start;
			start = start->second;
			delete temp;
			return res;
		}
		throw exception("Empty queue!\n");
	}
};
