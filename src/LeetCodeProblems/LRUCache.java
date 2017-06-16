/**
 * 
 */
package LeetCodeProblems;

import java.util.HashMap;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class LRUCache {

	int capacity;
	int cap;
	int lru;
	HashMap<Integer, Integer> valueHash; //key = capacity count, value = value
	HashMap<Integer, Integer> keyHash; //key = key, value = capacity count
	public LRUCache(int capacity) {
		valueHash = new HashMap<Integer, Integer>();
		keyHash = new HashMap<Integer, Integer>();
		this.capacity = capacity;
		this.cap = 0;
		this.lru = 0;
	}

	public int get(int key) {
		if(keyHash.get(key) == null) return -1;
		Integer out = valueHash.get(keyHash.get(key));
		if(out == null) return -1;
		if(keyHash.get(key) == lru)
			lru++;
		valueHash.remove(keyHash.get(key));
		keyHash.remove(key);
		keyHash.put(key, cap);
		valueHash.put(cap, out);
		cap++;
		return out;
	}

	public void put(int key, int value) {
		if(keyHash.get(key) != null){
			if(keyHash.get(key) == lru)
				lru++;
			valueHash.remove(keyHash.get(key));
			keyHash.remove(key);
		}
		if(keyHash.size() >= capacity){
			valueHash.remove(lru);
			lru++;
		}
		keyHash.put(key, cap);
		valueHash.put(cap, value);
		cap++;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache cache = new LRUCache( 2 /* capacity */ );

		cache.put(2, 1);
		cache.put(3, 2);    // evicts key 2
		cache.get(3);
		cache.get(2);
		cache.put(4, 3);    // evicts key 1
		cache.get(2);       // returns -1 (not found)
		cache.get(3);       // returns 3
		cache.get(4);

		/*	keyhash		  valuehash
		 * 2	3			3	1
		 * 3	2			2	2
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
	}

}
