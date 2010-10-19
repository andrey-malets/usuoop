using System.Collections.Generic;

namespace CharCounter.Counter
{
  interface ICounter<TK>
  {
    void Update(IEnumerable<TK> enumerable);
  }
}
