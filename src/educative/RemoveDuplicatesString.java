/**
 * 
 */
package educative;

import java.util.HashSet;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class RemoveDuplicatesString {

	public String remove(String s){
		if(s == null) return null;
		String out = "";
		HashSet<Character> hash = new HashSet<>();
		for(int i=0; i<s.length(); i++){
			char ch = s.charAt(i);
			if(!hash.contains(ch))
			{
				hash.add(ch);
				out += ch;
			}
		}
		return out;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicatesString obj = new RemoveDuplicatesString();
		System.out.println(obj.remove("tttrippitttiiiiiii"));
	}

}
