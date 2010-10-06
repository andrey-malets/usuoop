package map;

import java.util.Collection;
import java.util.Set;

public interface ImmutableMap<K,V> {
  
public int size();

public boolean isEmpty();

public boolean containsKey(Object key);

public boolean containsValue(Object value);

public V get(K key);
      
public Set<K> keySet();

public Collection<V> values();

public Set<java.util.Map.Entry<K, V>> entrySet();
}
