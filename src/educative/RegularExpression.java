/**
 * 
 */
package educative;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class RegularExpression {

	public boolean match(String in, String patt){
		Pattern pattern = Pattern.compile(patt);
		Matcher matcher = pattern.matcher(in);
		return matcher.matches();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegularExpression obj = new RegularExpression();
		System.out.println(obj.match("aabbbbbcdda", "a*b*c*da"));
	}

}
