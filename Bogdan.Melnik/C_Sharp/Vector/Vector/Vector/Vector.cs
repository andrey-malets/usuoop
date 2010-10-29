using System;
using System.Collections;
using System.Collections.Generic;
using Vector.Field;

namespace Vector.Vector
{
    class Vector<T> : IVector<T> where T : IField
    {
        private readonly List<T> _elems;
        private readonly int _dimension;

        public Vector(IEnumerable<T> a)
        {
            _elems = new List<T>();
            foreach (var field in a)
            {
                _elems.Add(field);
            }
            _dimension = _elems.Count;
        }

        public static Vector<T> operator +(Vector<T> rhs, IVector<T> lhs)
        {
            if (lhs == null) 
                throw new ArgumentNullException("lhs");
            if (rhs.GetDimension() != lhs.GetDimension())
                throw new MissmatchDimensionException();
            var temp = new List<T>();
            for (int i = 0; i < rhs.GetDimension(); ++i)
            {
                temp.Add(rhs.GetComponent(i) + lhs.GetComponent(i));
            }
        }

        public int GetDimension()
        {
            return _dimension;
        }

        public T GetComponent(int n)
        {
            return (T) _elems[n];
        }
    }

    internal class MissmatchDimensionException : Exception
    {
    }
}
