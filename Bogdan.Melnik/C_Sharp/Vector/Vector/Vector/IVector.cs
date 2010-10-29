using Vector.Field;

namespace Vector.Vector
{
    interface IVector<T>
    {
        int GetDimension();
        T GetComponent(int n);
    }
}
