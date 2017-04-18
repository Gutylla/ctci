/**
 * 
 */
package chapter1;

/**
 * @author triptibishnoi
 *
 */
public class ArraysStrings2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//reverse the string
		String var = "tripti";
		String revVar ="";
		int len= var.length();
		for(int i=len-1; i>=0; i--) {
			revVar += var.charAt(i); 
		}
		System.out.println(revVar);
	}

}
