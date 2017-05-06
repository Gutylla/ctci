/**
 * 
 */
package moderate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.tomcat.util.buf.CharChunk;

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

	//leet code-----------------------------
	public int lengthOfLongestSubstring(String s) {
		int len = s.length();
		int max = 0;
		HashMap<Character, Integer> hash = new HashMap<Character, Integer>(); 
		for(int index = 0, start = -1; index < len; index++){
			if(hash.containsKey(s.charAt(index))){
				int tempStart = hash.get(s.charAt(index));
				start = tempStart > start ? tempStart : start;
			}
			hash.put(s.charAt(index), index);
			max = Math.max(max,  hash.get(s.charAt(index)) - start);
		}
		return max;
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;

		double med1 = 0, med2 = 0;
		double median;

		if(len1 > 2){
			med1 = median(nums1, len1);
		}
		if(len2 > 2){
			med2 = median(nums2, len2);
		}

		if(med1 == med2)
			median = med1;
		else{ 
			if(med1 < med2){
				median = findMedianSortedArrays(nums1, nums2);
			}
			else{

			}
			median = (Math.max(nums1[0], nums2[0]) + Math.min(nums1[1], nums2[1])) / 2;
		}
		return median;
	}

	public double median(int[] arr, int len){
		if(len % 2 == 0) 
			return ((double)(arr[len/2-1] + arr[len/2]))/2;
		else
			return arr[len/2];
	}

	public int reverse(int x) {
		int result = 0;

		while (x != 0)
		{
			int tail = x % 10;
			int newResult = result * 10 + tail;
			if ((newResult - tail) / 10 != result)
				return 0;
			result = newResult;
			x = x / 10;
		}

		return result;
	}

	public boolean isPalindrome(int x) {
		if(x < 0) return false;
		int rev = reverse(x);
		return rev == x;
	}

	HashMap<Character, Integer> romanHash;
	//	HashMap<Integer, Character> intHash;

	public ModerateProblems(){
		romanHash = new HashMap<Character, Integer>();
		romanHash.put('I', 1);
		romanHash.put('V', 5);
		romanHash.put('X', 10);
		romanHash.put('L', 50);
		romanHash.put('C', 100);
		romanHash.put('D', 500);
		romanHash.put('M', 1000);

		//		intHash = new HashMap<Integer, Character>();
		//		intHash.put(1, 'I');
		//		intHash.put(5, 'V');
		//		intHash.put(10, 'X');
		//		intHash.put(50, 'L');
		//		intHash.put(100, 'C');
		//		intHash.put(500, 'D');
		//		intHash.put(1000, 'M');
	}

	public int romanToInt(String s) {
		int len = s.length();
		if(len == 0) return 0;
		int val;
		int out = 0;
		for(int i = len-1; i>=0;){
			int curr = romanHash.get(s.charAt(i));
			int prev = i-1 >= 0 ? romanHash.get(s.charAt(i-1)) : 0;
			if(curr > prev && prev != 0){
				val = curr - prev;
				i = i-2;
			}
			else{
				val = curr;
				i = i - 1;
			}
			out += val;
		}
		return out;
	}

	public String intToRoman(int num) {
		String[] M = {"", "M", "MM", "MMM"};
		String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
		String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
		String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
		return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
	}

	//		String out = "";
	//		int temp;
	//		int diff;
	//		int multiplier = 1000;
	//		while(num != 0){
	//			temp = (num / multiplier) * multiplier;
	//			out = out + intHash.get(temp);
	//			num = num % multiplier;
	//			multiplier = multiplier / 10;
	//		}
	//		return out;
	//	}

	public String longestCommonPrefix(String[] strs) {
		int arrLen = strs.length;
		if(arrLen==0) return "";
		String out = "";
		int freq = strs[0].length();
		for(int i=0; i<arrLen; i++){
			if(strs[i].length() < freq)
				freq = strs[i].length();
		}

		for(int i=0; i<freq; i++){
			char pre = strs[0].charAt(i);
			for(int j=1; j<arrLen; j++){
				if(strs[j].charAt(i) != pre)
					return out;
			}
			out = out + pre;
		}
		return out;
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		HashMap<Character, Character> mapping = new HashMap<Character, Character>();

		mapping.put(']', '[');
		mapping.put(')', '(');
		mapping.put('}', '{');

		for(int i = 0; i < s.length(); i++){
			if(mapping.containsKey(s.charAt(i))){
				if(stack.pop() != mapping.get(s.charAt(i)))
					return false;
			} else {
				stack.push(s.charAt(i));
			}
		}
		return stack.isEmpty() ? true : false;
	}

	public double myPow(double x, int n) {
		double temp = x;
		if(n==0)
			return 1;

		temp=myPow(x,n/2);

		if(n%2==0)
			return temp*temp;
		else 
		{
			if(n > 0)
				return x*temp*temp;
			else
				return (temp*temp)/x;
		}
	}

	//	public List<List<String>> groupAnagrams(String[] strs) {
	//		if(null!=var1 && null!= var2 && "" != var1 && "" != var2) {
	//			int len1 = var1.length();
	//			int len2 = var2.length();
	//			char minValue;
	//			int minIndex;
	//			char temp;
	//			char[] varArray1 = var1.toCharArray();
	//			char[] varArray2 = var2.toCharArray();
	//			if(len1 == len2) {
	//				//-----------sort 
	//				for(int i=0; i<len1; i++){
	//					minValue = varArray1[i];
	//					minIndex = i;
	//					for(int j=i+1; j<len1;j++){
	//						if(varArray1[j] < minValue){
	//							minIndex = j;
	//							minValue = varArray1[j];
	//						}
	//					}
	//					temp = varArray1[i];
	//					varArray1[i] = minValue;
	//					varArray1[minIndex] = temp;
	//				}
	//				var1 = String.valueOf(varArray1);
	//				//-------------sort
	//				for(int i=0; i<len2; i++){
	//					minValue = varArray2[i];
	//					minIndex = i;
	//					for(int j=i+1; j<len2;j++){
	//						if(varArray2[j] < minValue){
	//							minIndex = j;
	//							minValue = varArray2[j];
	//						}
	//					}
	//					temp = varArray2[i];
	//					varArray2[i] = minValue;
	//					varArray2[minIndex] = temp;
	//				}
	//				var2 = String.valueOf(varArray2);
	//				//-----------compare
	//				for(int i=0; i<len1; i++){
	//					if(var1.charAt(i) != var2.charAt(i)){
	//						System.out.println("not anagrams");
	//						break;
	//					}
	//				}
	//				System.out.println("anagrams!!");
	//			}
	//			else {
	//				System.out.println("not anagrams");
	//			}
	//		}
	//		else{
	//			System.out.println("blank or null");
	//		}
	//	}
	//}

	private void selectionSort(int[] nums){
		int min;
		for(int i=0; i<nums.length; i++){
			min = nums[i];
			for(int j=i+1; j<nums.length; j++){
				if(nums[j] < min){
					int temp = nums[j];
					nums[j] = nums[i];
					nums[i] = temp;
				}
			}
		}
	}

	public int longestValidParentheses(String s) {
		int max = 0;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == '(')
				stack.push(i);
			else{
				stack.pop();
				if(stack.empty())
					stack.push(i);
				else
					max = Math.max(max, i-stack.peek());
			}
		}
		return max;
	}

	public int searchInsert(int[] nums, int target) {
		if(nums.length == 0) return 0;
		int index = -1;
		index = this.binarySearch(nums, target, 0, nums.length-1);
		return index;
	}

	private int binarySearch(int[] nums, int target, int start, int end){
		if (start < end) {
			int mid = start + (end - start) / 2; 
			if (target < nums[mid]) {
				return binarySearch(nums, target, start, mid);

			} else if (target > nums[mid]) {
				return binarySearch(nums, target, mid+1, end);

			} else {
				return mid;  
			}
		}
		else if(start == end){
			if(target <= nums[start])
				return start;
			else
				return start + 1;
		}
		return -(start + 1);
	}

	//	public boolean isValidSudoku(char[][] board) {
	//		int rows = board.length;
	//		int cols = board[0].length;
	//		boolean flag = true;
	//		//check rows
	//		for(int r=0; r<rows; r++){
	//			if(flag)
	//				flag = flag && this.areValidRowsCols(board[r]);
	//			else
	//				return false;
	//		}
	//		//check cols
	////		for(int c=0; c<cols; c++){
	////			if(flag)
	////				flag = flag && this.areValidRowsCols();
	////			else
	////				return false;
	////		}
	//		return false;
	//	}

	//	private boolean areValidRowsCols(char[] arr){
	//		for(int i=0; i<arr.length; i++){
	//			for(int j=i+1; j<arr.length; j++){
	//				if(arr[i]==arr[j])
	//					return false;
	//			}
	//		}
	//		return true;
	//	}

	public boolean isMatch(String s, String p) {
		String pattern = "";
		if(p == "*")
			pattern = ".*";
		else{
			for(int i=0; i<p.length(); i++){
				if(p.charAt(i) == '*')
					pattern += '+';
				else if(p.charAt(i) == '?')
					pattern += '.';
				else
					pattern += p.charAt(i);
			}
		}
		//Pattern pat = Pattern.compile(pattern);
		return s.matches(pattern);
		//Matcher matcher = pat.matcher(s);
		//return matcher.matches() ? true : false;
	}

	public String multiply(String num1, String num2) {
		int m = num1.length();
		int n = num2.length();
		int[] res = new int[m + n];

		for (int i=m-1; i>=0; i--) {
			for (int j=n-1; j>=0; j--) {
				int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int carryPtr = i+j;
				int ptr = i+j+1;
				int sum = mul + res[ptr];
				res[carryPtr] += sum/10;
				res[ptr] = sum % 10;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int r : res) {
			if (sb.length() == 0 && r == 0) continue;
			sb.append(r);
		}
		return sb.length() == 0 ? "0" : sb.toString();
	}

	public int trap(int[] height) {
		int trap = 0;
		int prevLow = 0;
		if(height.length > 1){
			for(int front=0, back=height.length-1; front<height.length && back>=0 && back>=front;){
				if(height[front] >= height[back] && height[front] != 0 && height[back] != 0 && 
						height[back] >= prevLow && height[front] >= prevLow){
					if(front == back)
						trap -= prevLow;
					else
						if(height[front] >= height[back])
							trap += (back - front -1) * (height[back] - prevLow) - 2 * prevLow;
						else
							trap += (back - front -1) * (height[front] - prevLow) - 2 * prevLow;
					if(height[front] >= height[back])
						prevLow = height[back];
					else
						prevLow = height[front];
					front++;
					back--;
				}
				else{
					if(height[front] == height[back] && height[back] < prevLow){
						if(front == back)
							trap -= height[back];
						else
							trap -= 2 * height[back];
						front++;
						back--;
					}
					else if(height[front] < prevLow){
						trap -= height[front];
						front++;
					}
					else if(height[back] < prevLow){
						trap -= height[back];
						back--;
					}
					else{
						front++;
					}
				}
			}
		}
		return trap;
	}


	public static void main(String[] args) {
		ModerateProblems obj = new ModerateProblems();
		int[] height = {5,5,1,7,1,1,5,2,7,6};
//		System.out.println(obj.trap(height));
		//System.out.println(obj.multiply("123456789", "987654321"));
//		System.out.println(obj.isMatch("aa", "*"));
		//char[][] board = {(),(),()};

		//int[] nums ={40};
		//System.out.println(obj.searchInsert(nums, 40));
		//System.out.println(obj.longestValidParentheses(")))()"));


		//		System.out.println(obj.myPow(1,4));
		//		Math.pow(0, 1);
		//System.out.println(obj.isValid("({}){"));

		//String[] arr = {"tripti", "", "trips"};
		//System.out.println(obj.longestCommonPrefix(arr));

		//System.out.println(obj.intToRoman(0));
		//System.out.println(obj.romanToInt(""));
		//System.out.println(obj.isPalindrome(2147483647));
		//System.out.println(obj.reverse(234));
		//System.out.println(obj.lengthOfLongestSubstring("abba"));

		//System.out.println(obj.findMedianSortedArrays(new int[] {1,1}, new int[] {1,2}));

		//		System.out.println("-------");
		//		obj.numberSwapper(4, 10);
		//		String[] book = {"my ", " name", "my", "my  ", "name    "};
		//		String word = "MY";
		//		System.out.println(obj.wordFreq(book,word));
		//		System.out.println(obj.wordFreq(book,word));
	}

}

