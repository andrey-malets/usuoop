package counter;

import java.util.HashMap;
import map.FilterMap;
import map.ImmutableMap;

public class HashCounter<K> implements Counter<K> {
  
  private final HashMap<K,Integer> hashMap;
  
  public HashCounter() {
    hashMap = new HashMap<K, Integer>();
  }
  
  public void updateState(Iterable<K> iterator) {
    for (K k : iterator) {
      Integer value = hashMap.get(k);
      hashMap.put(k, (value == null) ? 1 : value.intValue() + 1);
    }
  }

  public ImmutableMap<K, Integer> getCurrentState() {
    return new FilterMap<K, Integer>(hashMap);
  }
  
  public void clearState() {
    hashMap.clear();
  }
  public String toString() {
    return hashMap.toString();    
  }
}
