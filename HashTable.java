import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Set;

public class HashTable<K, V> {
  public static class HashNode<K, V> {
    private K key;
    private V value;

    private HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
      return value;
    }

    public void setValue(V value) {
      this.value = value;
    }
  }

  private LinkedList<HashNode<K, V>>[] table;
  private int size;

  public HashTable() {
    this(10);
  }

  @SuppressWarnings("unchecked")
  public HashTable(int capacity) {
    this.table = new LinkedList[capacity];
    for (int i = 0; i < this.table.length; i++) {
      this.table[i] = new LinkedList<>();
    }
    this.size = 0;
  }

  private int hash(K key) {
    return key.hashCode() % this.table.length;
  }

  private HashNode<K, V> find(K key) {
    int index = hash(key);
    for (HashNode<K, V> node: this.table[index]) {
      if (node.key.equals(key)) {
        return node;
      }
    }
    return null;
  }

  public void push(K key, V value) {
    int index = hash(key);
    HashNode<K, V> node = find(key);
    if (node != null) {
      node.value = value;
    } else {
      this.table[index].push(new HashNode<>(key, value));
      this.size++;
    }
  }

  public V getValue(K key) {
    HashNode<K, V> node = find(key);
    return node != null ? node.value : null;
  }

  public HashNode<K, V> get(K key) {
    return find(key);
  }

  public V remove(K key) {
    int index = hash(key);
    HashNode<K, V> node = find(key);
    if (node != null) {
      this.table[index].remove(node);
      this.size--;
      return node.value;
    }
    return null;
  }

  public Set<K> keySet() {
    Set<K> keys = new HashSet<>();
    for (LinkedList<HashNode<K, V>> bucket : table) {
        for (HashNode<K, V> node : bucket) {
            keys.add(node.key);
        }
    }
    return keys;
  }

  public Iterator<HashNode<K, V>> iterator() {
    return new Iterator<HashNode<K, V>>() {
      private int bucketIndex = 0;
      private Iterator<HashNode<K, V>> bucket = table[bucketIndex].iterator();
      private HashNode<K, V> nextNode = findNext();

      private HashNode<K, V> findNext() {
        while (bucketIndex < table.length) {
          if (bucket.hasNext()) {
            return bucket.next();
          } else {
            if (++bucketIndex < table.length) {
              bucket = table[bucketIndex].iterator();
            }
          }
        }
        return null;
      }

      @Override
      public boolean hasNext() {
        return nextNode != null;
      }

      @Override
      public HashNode<K, V> next() {
        if (nextNode == null) {
          throw new NoSuchElementException("Iterator end");
        }
        HashNode<K, V> currentNode = nextNode;
        nextNode = findNext();
        return currentNode;
      }
    };
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    result.append("{");
    Iterator<HashNode<K, V>> iterator = iterator();
    while (iterator.hasNext()) {
      HashNode<K, V> node = iterator.next();
      result.append(String.format("%s=%s,", node.key, node.value));
    }
    result.deleteCharAt(result.length() - 1);
    result.append("}");    
    return result.toString();
  }

  public static void main(String[] args) {
    HashTable<String, String> table = new HashTable<>();
    table.push("1", "A");
    table.push("2", "B");
    table.push("3", "C");
    table.push("3", "D");
    table.push("5", "E");
    table.remove("2");
    System.out.println(table);
  }
}