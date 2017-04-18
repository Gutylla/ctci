/**
 * 
 */
package chapter1;


/**
 * @author triptibishnoi
 *
 */
public class ArraysStrings3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String var = "";
		String revVar ="";
		char c;
		char blank = 0;
		if(null != var && "" != var) {
			for (int i=0; i<var.length();i++){
				c= var.charAt(i);
				System.out.println("loop count: " + i );
				var = var.replace(c, blank);
				revVar += c;
			}
		}
		System.out.println("output: " + revVar);
	}

}
