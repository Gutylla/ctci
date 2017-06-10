/**
 * 
 */
package educative;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class ReverseWordsInSentence {

	public void reverseHelper(char[] str, int start, int end){
		while(start < end){
			char temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}
	}

	public String reverseSentence(char[] sentence){
		if(sentence == null || sentence.length <= 1) return null;

		reverseHelper(sentence, 0, sentence.length-1);

		int start = 0;
		int end = 0;

		while(true){
			if(start > sentence.length-1)
				break;
			
			while(sentence[start] == ' ')
				start++;

			end = start;
			while(end <= sentence.length-1 && sentence[end] != ' ')
				end++;

			reverseHelper(sentence, start, end-1);

			start = end;
		}

		//		int i = 0;
		//		int start = 0;
		//		int end = 0;
		//		while(i < sentence.length){
		//			if(sentence[i] == ' '){
		//				end = i-1;
		//				reverseHelper(sentence, start, end);
		//				start = i+1;
		//				end = i+1;
		//			}
		//			if(i == sentence.length-1){
		//				end = i;
		//				reverseHelper(sentence, start, end);
		//				start = i+1;
		//				end = i+1;
		//			}
		//			i++;
		//		}
		return new String(sentence);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] sen = {'t', 'o', ' ', 't', 'r', 'i', 'p', '!'};
		ReverseWordsInSentence obj = new ReverseWordsInSentence();
		System.out.println(obj.reverseSentence(sen));
	}

}
