

using System;
using System.Collections;
using CharCounter.Counter;

namespace CharCounter
{
  internal class Program
  {
    private static void Main()
    {
      var hashCounter = new HashCounter<Char>();
      hashCounter.Update("1234512345");
      foreach (DictionaryEntry k in hashCounter.State())
      {
        Console.WriteLine(k.Key + " " + k.Value);
      };
    }
  }
}