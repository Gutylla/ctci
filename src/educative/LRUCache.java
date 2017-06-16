/**
 * 
 */
package educative;

import java.util.HashMap;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class LRUCache {

	int capacity;
	int cap;
	int lru;
	HashMap<Integer, Integer> keyHash; //key = key, value = capacity count
	public LRUCache(int capacity) {
		keyHash = new HashMap<Integer, Integer>();
		this.capacity = capacity; // max size of cache
		this.lru = 0; // to keep track of when was accessed, lesser the value least recently used
	}

	public int get(int key) {
		if(!keyHash.containsKey(key)){
			System.out.println("doesnt contain!!");
			return -1;
		}
		keyHash.remove(key);
		keyHash.put(key, lru++);
		return key;
	}

	public void put(int key) {
		if(keyHash.size() >= capacity){
			int min = lru+1;
			int keytobedeleted = -1;
			for(int k : keyHash.keySet()){
				if(keyHash.get(k) < min){
					min = keyHash.get(k);
					keytobedeleted = k;
				}
			}
			keyHash.remove(keytobedeleted);
		}
		keyHash.put(key, lru++);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache cache = new LRUCache( 2 /* capacity */ );

		cache.put(2);
		cache.put(3);    // evicts key 2
		cache.get(3);
		cache.get(2);
		cache.put(4);    // evicts key 1
		cache.get(2);       // returns -1 (not found)
		cache.get(3);       // returns 3
		cache.get(4);
	}

}
