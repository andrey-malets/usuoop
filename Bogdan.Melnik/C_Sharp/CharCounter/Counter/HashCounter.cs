using System;
using System.Collections.Generic;

namespace CharCounter.Counter
{
  class HashCounter<TK> : ICounter<TK>
  {
    public void Update(IEnumerable<TK> enumerable)
    {
      foreach (var k in enumerable)
      {
        Console.WriteLine(enumerable.ToString());
      }
    }
  }
}
