using System;

namespace Vector.Field
{
    internal class BinaryField : IField,IComparable
    {
        private readonly int _value;

        public BinaryField(int init)
        {
            if (init != 0 && init != 1)
                throw new InvalidValueException();
            _value = init;
        }

        public static BinaryField operator +(BinaryField lhs, BinaryField rhs)
        {
            return new BinaryField( (lhs._value + rhs._value) % 2 );
        }

        public static BinaryField operator-(BinaryField lhs,BinaryField rhs)
        {
            return new BinaryField((lhs._value + rhs._value) % 2);
        }

        public static BinaryField operator-(BinaryField lhs)
        {
            return new BinaryField( 1 - lhs._value );
        }

        public static BinaryField operator*(BinaryField lhs,BinaryField rhs)
        {
            return new BinaryField( lhs._value * rhs._value );
        }

        public static BinaryField operator/(BinaryField lhs,BinaryField rhs)
        {
            return new BinaryField( lhs._value / rhs._value );
        }

        public override String ToString()
        {
            return _value.ToString();
        }

        public int CompareTo(object obj)
        {
            var rhs = obj as BinaryField;
            return _value.CompareTo(rhs._value);
        }

        public static bool operator==(BinaryField lhs,BinaryField rhs)
        {
            return lhs._value == rhs._value;
        }

        public static bool operator !=(BinaryField lhs, BinaryField rhs)
        {
            return !(lhs._value == rhs._value);
        }

        public bool Equals(BinaryField other)
        {
            if (ReferenceEquals(null, other)) return false;
            if (ReferenceEquals(this, other)) return true;
            return other._value == _value;
        }

        public override bool Equals(object obj)
        {
            if (ReferenceEquals(null, obj)) return false;
            if (ReferenceEquals(this, obj)) return true;
            if (obj.GetType() != typeof (BinaryField)) return false;
            return Equals((BinaryField) obj);
        }

        public override int GetHashCode()
        {
            return _value;
        }
    }

    internal class InvalidValueException : Exception
    {
    }
}
