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
		for(int i=0, p=0; i<in.length() && p<patt.length();){
			if(patt.charAt(p) == in.charAt(i) || patt.charAt(p) == '.'){
				p++;
				i++;
			}
			else if(patt.charAt(p) == '*'){
				char prevPatt = patt.charAt(p-1);
				while(in.charAt(i) == prevPatt)
					i++;
				p++;
			}
			else
				return false;
		}
		return true;

		//		Pattern pattern = Pattern.compile(patt);
		//		Matcher matcher = pattern.matcher(in);
		//		return matcher.matches();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegularExpression obj = new RegularExpression();
		System.out.println(obj.match("aabbbbbcdda", "a*b*c*dda"));
	}

}
