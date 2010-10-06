package counter;

import map.ImmutableMap;

public interface Counter<K> {
  public void updateState(Iterable<K> iterator);
  public ImmutableMap<K,Integer> getCurrentState();
  public void clearState();
}
