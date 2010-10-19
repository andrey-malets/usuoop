using System.Collections;
using System.Collections.Generic;

namespace CharCounter.Counter
{
  interface ICounter<TK>
  {
    void Update(IEnumerable<TK> enumerable);
    void Clearstate();
    IDictionary State();
  }
}
