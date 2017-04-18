/**
 * 
 */
package chapter1;

import java.util.ArrayList;

/**
 * @author triptibishnoi
 *
 */
public class ArraysStrings6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] coins = {1,2,10};
		int price = 28;
		int len = coins.length;
		int count =0;
		for(int i=len-1; i>=0 && price!=0 ; i--){
			count += price / coins[i];
			price %= coins[i];
		}
		System.out.println(count);
	}
}
