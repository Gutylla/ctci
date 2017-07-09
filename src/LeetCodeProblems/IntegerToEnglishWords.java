/**
 * 
 */
package LeetCodeProblems;

import java.util.HashMap;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class IntegerToEnglishWords {

	public String numberToWords(int num) {
		if(num == 0)
			return "Zero";
		HashMap<Integer, String> numHash = new HashMap<>();
		HashMap<Integer, String> tensHash = new HashMap<>();
		HashMap<Integer, String> otherHash = new HashMap<>();
		HashMap<Integer, HashMap<Integer, String>> hashNames = new HashMap<>();
		HashMap<Integer, String> constantHash = new HashMap<>();
		final String HUNDRED = "Hundred";
		final String THOUSAND = "Thousand";
		final String MILLION = "Million";
		final String BILLION = "Billion";

		numHash.put(1, "One");
		numHash.put(2, "Two");
		numHash.put(3, "Three");
		numHash.put(4, "Four");
		numHash.put(5, "Five");
		numHash.put(6, "Six");
		numHash.put(7, "Seven");
		numHash.put(8, "Eight");
		numHash.put(9, "Nine");

		tensHash.put(10, "Ten");
		tensHash.put(11, "Eleven");
		tensHash.put(12, "Tweleve");
		tensHash.put(13, "Thirteen");
		tensHash.put(14, "Fourteen");
		tensHash.put(15, "Fifteen");
		tensHash.put(16, "Sixteen");
		tensHash.put(17, "Seventeen");
		tensHash.put(18, "Eighteen");
		tensHash.put(19, "Ninteen");

		otherHash.put(2, "Twenty");
		otherHash.put(3, "Thirty");
		otherHash.put(4, "Forty");
		otherHash.put(5, "Fifty");
		otherHash.put(6, "Sixty");
		otherHash.put(7, "Seventy");
		otherHash.put(8, "Eighty");
		otherHash.put(9, "Ninty");

		hashNames.put(0, numHash);
		hashNames.put(1, otherHash);
		hashNames.put(2, numHash);
		hashNames.put(3, numHash);
		hashNames.put(4, otherHash);
		hashNames.put(5, numHash);
		hashNames.put(6, numHash);
		hashNames.put(7, otherHash);
		hashNames.put(8, numHash);
		hashNames.put(9, numHash);

		constantHash.put(2, HUNDRED);
		constantHash.put(3, THOUSAND);
		constantHash.put(5, HUNDRED);
		constantHash.put(6, MILLION);
		constantHash.put(8, HUNDRED);
		constantHash.put(9, BILLION);

		String out = "";
		String input = String.valueOf(num);
		int len = input.length();
		for(int i=0; i<len; i++){
			int val = Character.getNumericValue(input.charAt(i));
			if(hashNames.get(len - i - 1).get(val) == null)
				out += tensHash.get(val*10 + Character.getNumericValue(input.charAt(++i))) + " ";
			else if(len - i - 1 != 0 && Character.getNumericValue(input.charAt(i+1)) == 0){
				out += otherHash.get(val) + " ";
				i++;
			}
			else
				out += hashNames.get(len - i - 1).get(val) + " ";
			if(constantHash.get(len - i - 1) != null)
				out += constantHash.get(len - i - 1) + " ";
		}

		return out.trim();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerToEnglishWords obj = new IntegerToEnglishWords();
		System.out.println(obj.numberToWords(1000));
	}

}
