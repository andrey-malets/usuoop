package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FilterMap<K,V> implements ImmutableMap<K,V> {
  private final Map<K,V> hashMap;
  
  public FilterMap(Map<K, V> hashMap)  {
    this.hashMap = new HashMap<K, V>(hashMap);
  }
  
  public int size() {
      return hashMap.size();
  }

  public boolean isEmpty() {
    return hashMap.isEmpty();    
  }

  public boolean containsKey(Object key) {      
    return hashMap.containsKey(key); 
  }

    public boolean containsValue(Object value) {    
    return hashMap.containsValue(value);
  }

  public V get(K key) {
    return hashMap.get(key);
  }
        
  public Set<K> keySet() {    
    return hashMap.keySet();
  }

  public Collection<V> values() {    
    return hashMap.values();
  }
  
  public Set<java.util.Map.Entry<K, V>> entrySet() {    
    return hashMap.entrySet();
  }
  
  public String toString() {
    return hashMap.toString();    
  }
  
}
