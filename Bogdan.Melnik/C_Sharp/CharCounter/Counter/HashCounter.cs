using System.Collections;
using System.Collections.Generic;

namespace CharCounter.Counter
{
  class HashCounter<TK> : ICounter<TK>
  {
    private readonly Hashtable _hashtable;
    public HashCounter()
    {
      _hashtable = new Hashtable();
    }

    public void Update(IEnumerable<TK> enumerable)
    {
      foreach (var k in enumerable)
      {
        if (_hashtable.ContainsKey(k))
        {
          var newValue = (int)_hashtable[k] + 1;
          _hashtable.Remove(k);
          _hashtable.Add(k,newValue);
        } else
        {
          _hashtable.Add(k,1);
        }
      }
    }

    public void Clearstate()
    {
      _hashtable.Clear();
    }

    public IDictionary State()
    {
      return new Hashtable(_hashtable);
    }
  }
}
