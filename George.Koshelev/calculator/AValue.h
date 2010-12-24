class AbstractValue
{
public:
virtual void print() = 0;
virtual AbstractValue* add (const AbstractValue & operand) const = 0;
virtual AbstractValue* sub (const AbstractValue & operand) const = 0;
virtual AbstractValue* mul (const AbstractValue & operand) const = 0;
virtual AbstractValue* div (const AbstractValue & operand) const = 0;
virtual ~AbstractValue();
};
AbstractValue::~AbstractValue(){};
