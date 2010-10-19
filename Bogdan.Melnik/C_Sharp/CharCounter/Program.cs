

using System.Collections.Generic;

namespace CharCounter
{
  internal class Program
  {
    private static void Main()
    {
      var hashCounter = new Counter.HashCounter<char>();
      var list = new List<char>();
      list.Add('1');
      hashCounter.Update(list);
    }
  }
}