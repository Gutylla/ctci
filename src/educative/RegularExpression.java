/**
 * 
 */
package educative;


/**
 * @author TriptiAshishUpadhyay
 *
 */
public class RegularExpression {

	public boolean match(String in, String patt){
		boolean out = true;
		int i=0, p=0;
		while(i<in.length() && p<patt.length()){
			if(patt.charAt(p) == in.charAt(i) || patt.charAt(p) == '.'){
				p++;
				i++;
				out &= true;
			}
			else if(patt.charAt(p) == '*'){
				char prevPatt = patt.charAt(p-1);
				while(i<in.length()){
					if(prevPatt == '.' || in.charAt(i) == prevPatt){
						i++;
						out &= true;
					}
					else{
						out &= false;
					}
				}
				p++;
			}
			else
				out &= false;
		}
		return out;



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
		System.out.println(obj.match("aa", ".*"));
	}

}
