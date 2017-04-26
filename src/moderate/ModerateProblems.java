/**
 * 
 */
package moderate;

import java.util.HashMap;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class ModerateProblems {

	//Problem 16.1
	public void numberSwapper(int var1, int var2){
		System.out.println("before: var1- "+ var1 + ", var2- "+var2);
		var1 = var1 ^ var2;
		var2 = var1 ^ var2;
		var1 = var1 ^ var2;
		System.out.println("after: var1- "+ var1 + ", var2- "+var2);
	}

	//Problem 16.2
	HashMap<String, Integer> bookHash = new HashMap<String, Integer>();

	public int wordFreq(String[] book, String word){
		word = word.trim().toLowerCase();
		int count = 0;
		if(bookHash.get(word) != null) return bookHash.get(word);
		else{
			for(String w: book){
				if(w.trim().toLowerCase().equals(word)){
					count++;
				}
			}
			bookHash.put(word, count);
		}
		return count;
	}

	public static void main(String[] args) {
		ModerateProblems obj = new ModerateProblems();
		obj.numberSwapper(4, 10);
		String[] book = {"my ", " name", "my", "my  ", "name    "};
		String word = "MY";
		System.out.println(obj.wordFreq(book,word));
		System.out.println(obj.wordFreq(book,word));
	}

}
