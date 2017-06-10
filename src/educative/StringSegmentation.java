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
		boolean flag = false;
		int dicLen = dic.length;
		int strLen = str.length();
		int start = 0;
		int end = strLen;
		for(int i=0; i<strLen; i++){
			String word1 = str.substring(start, i+1);
			String word2 = str.substring(i+1, end);
			if(hasWord(dic, word1)){
				flag = flag && segmented(dic, word2);
			}
		}
		return flag;
	}
	
	private boolean hasWord(String[] dic, String word){
		for(int i=0; i<dic.length; i++){
			if(dic[i] == word)
				return true;
		}
		return false;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
