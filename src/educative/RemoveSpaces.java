/**
 * 
 */
package educative;


/**
 * @author TriptiAshishUpadhyay
 *
 */
public class RemoveSpaces {

	public String remove(String s){
		if(s == null) return null;
		String out = "";
		for(int i=0; i< s.length(); i++){
			char ch = s.charAt(i);
			if(ch != ' ')
				out += ch;
		}
		return out;
	}
	
	
	//using read write pointer
	public String rs(char[] s){
		if(s == null || s.length < 1) return null;
		int read = 0;
		int write = 0;
		while(read < s.length && write < s.length){
			if(s[write] != ' '){
				s[read] = s[write];
				read++;
			}
			write++;
		}
		while(read < write){
			s[read] = ' ';
			read++;
		}
		return new String(s);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveSpaces obj = new RemoveSpaces();
		System.out.println(obj.rs(("  tri p    ti    ").toCharArray()));
	}

}
