/**
 * 
 */
package LeetCodeProblems;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class MinWindowSubstring {

	public String minWindow(String s, String t) {
		ArrayList<String> output = new ArrayList<>();
		int start = 0;
		int i = 0;
		int len = s.length();
		int tLen = t.length();
		
		HashMap<Character, Integer> hash = new HashMap<>();
		for(char ch : t.toCharArray()){
			hash.put(ch, 1);
		}
		
		while(i < len && tLen > 0){
			char ch = s.charAt(i);
			if(hash.containsKey(ch)){
				if(hash.get(ch) >= 0)
					tLen--;
				hash.put(ch, hash.get(ch)-1);
				if(tLen == 0){
					while(start < len){
						char sChar = s.charAt(start);
						if(hash.containsKey(sChar)){
							output.add(s.substring(start, i+1));
							hash.put(sChar, hash.get(sChar)+1);
							start++;
							tLen++;
							break;
						}
						else
							start++;
					}
				}
			}
			i++;
		}
		
		System.out.println("done");

		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinWindowSubstring obj = new MinWindowSubstring();
		obj.minWindow("ADOBECODEBANC", "ABC");
	}

}
