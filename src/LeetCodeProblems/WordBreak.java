/**
 * 
 */
package LeetCodeProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class WordBreak {

	public boolean wordBreak(String s, List<String> wordDict) {
		return !DFS(s, wordDict, new HashMap<String, LinkedList<String>>()).isEmpty();
	}	

	private LinkedList<String> DFS(String s, List<String> wordDict, HashMap<String, LinkedList<String>> hash) {
		if(hash.containsKey(s))
			return hash.get(s);
		
		LinkedList<String> val = new LinkedList<String>();
		
		if(s.length() == 0){
			val.add("");
			return val;
		}
		
		for(String word: wordDict){
			if(s.startsWith(word)){
				List<String> subList = DFS(s.substring(word.length()), wordDict, hash);
				for(String sub:subList)
					val.add(word + (sub.isEmpty() ? "" : " ") + sub);
			}
		}
		
		hash.put(s, val);
		return val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
