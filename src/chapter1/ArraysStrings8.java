/**
 * 
 */
package chapter1;


/**
 * @author triptibishnoi
 *
 */
public class ArraysStrings8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "waterbottle";
		String s2 = "bottleWater";
		ArraysStrings8 var = new ArraysStrings8();
		System.out.println(var.isSubstring(s1, s2));
		
	}
	
	//check if s2 is a rotation of s1 using only one call
	public boolean isSubstring(String s1, String s2) {
		int l1= s1.length();
		int l2= s2.length();
		if(l1==l2 && l1>0){
			String newS1 = s1 + s1;
			return newS1.toLowerCase().contains(s2.toLowerCase())? true: false;
		}
		return false;
	}
}