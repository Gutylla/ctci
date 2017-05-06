/**
 * 
 */
package PageTwo;

import java.util.Arrays;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class InterleavingString {

	public boolean isInterleave(String s1, String s2, String s3) {
		if(s3.length() != (s1.length() + s2.length()))
				return false;
		s1 = s1 + s2;
		s1 = sortString(s1);
		s3 = sortString(s3);
		return s1.equalsIgnoreCase(s3);
	}
	
	private String sortString(String s){
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
	
	public static void main(String[] args) {
		InterleavingString obj = new InterleavingString();
		System.out.println("-------");
		System.out.println(obj.isInterleave("ab", "bc", "bbac"));
	}

}
