/**
 * 
 */
package educative;

import java.util.ArrayList;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class PermuteString {

	public void permute(String input, String currentPattern, ArrayList<String> result){
		if(input.length() == 0){
			result.add(currentPattern);
			System.out.println(currentPattern);
			return;
		}

		for(int i=0; i<input.length(); i++){
			StringBuilder temp = new StringBuilder(input);
			currentPattern = currentPattern + input.charAt(i);
			temp.deleteCharAt(i);
			permute(temp.toString(), currentPattern, result);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermuteString obj = new PermuteString();
		String input = "AAB";
		obj.permute(input, "", new ArrayList<String>());
	}

}
