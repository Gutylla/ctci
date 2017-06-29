/**
 * 
 */
package educative;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class StringSegmentation {
	
	public boolean segmented(String[] dic, String str){
		int strLen = str.length();
		int start = 0;
		int end = strLen;
		for(int i=0; i<strLen; i++){
			String word1 = str.substring(start, i+1);
			String word2 = str.substring(i+1, end);
			if(hasWord(dic, word1)){
				if(word2.length() == 0 || hasWord(dic, word2))
					return true;
				return segmented(dic, word2);
			}
		}
		return false;
	}
	
	private boolean hasWord(String[] dic, String word){
		for(int i=0; i<dic.length; i++){
			if(dic[i].equals(word))
				return true;
		}
		return false;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringSegmentation obj = new StringSegmentation();
		System.out.println(obj.segmented(new String[]{"apple","peer","pie"}, "applepie"));
	}

}
