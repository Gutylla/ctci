/**
 * 
 */
package educative;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class AllPalindromeSubStrings {

	public void findAllPalindromes(String input){
		for(int i=0; i<input.length(); i++){
			helper(input, i-1, i+1);
			helper(input, i, i+1);
		}
	}
	
	private void helper(String s, int prev, int next){
		for(;prev >= 0 && next < s.length(); prev--, next++){
			if(s.charAt(prev) != s.charAt(next))
				return;
			System.out.println(s.substring(prev, next+1));
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllPalindromeSubStrings obj = new AllPalindromeSubStrings();
		obj.findAllPalindromes("aabbbaa");
	}

}
