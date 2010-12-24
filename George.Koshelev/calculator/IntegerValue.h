#include "AValue.h"
#include "DivizionByZero.h"
class IntegerValue : public AbstractValue
{
private:
	size_t value;
public:
	IntegerValue(int);
virtual void print();
AbstractValue* add(const AbstractValue&) const;
AbstractValue* sub(const AbstractValue&) const;
AbstractValue* mul(const AbstractValue&) const;
AbstractValue* div(const AbstractValue&) const;
virtual ~IntegerValue();
size_t getValue() const;
};
void IntegerValue::print(){
	std::cout<<this->value;
}
IntegerValue::IntegerValue(int val){
	this->value = val;
}
size_t IntegerValue::getValue() const{
	return value;
}
IntegerValue::~IntegerValue(){};

AbstractValue* IntegerValue::add(const AbstractValue& operand)  const {
	return new IntegerValue(this->value + static_cast <const IntegerValue*> (&operand)->getValue());
}
AbstractValue* IntegerValue::sub(const AbstractValue& operand)  const {
	return new IntegerValue(this->value - static_cast <const IntegerValue*> (&operand)->getValue());
}
AbstractValue* IntegerValue::mul(const AbstractValue& operand)  const {
	return new IntegerValue(this->value * static_cast <const IntegerValue*> (&operand)->getValue());
}
AbstractValue* IntegerValue::div(const AbstractValue& operand)  const {
	int temp = static_cast <const IntegerValue*> (&operand)->getValue();
	if (temp == 0) {throw DivisionByZeroException();}
	return new IntegerValue(this->value / temp);
}
