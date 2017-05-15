/**
 * 
 */
package LeetCodeProblems;

import java.util.Arrays;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class Candy {

	public int candy(int[] ratings) {
		int[] l2r = new int[ratings.length]; //left to right
		int[] r2l = new int[ratings.length]; //right to left
		int max = 0;
		Arrays.fill(l2r, 1);
		Arrays.fill(r2l, 1);
		for(int i=1; i<ratings.length; i++){
			if(ratings[i]>ratings[i-1])
				l2r[i] = l2r[i-1]+1;
		}
		for(int i=ratings.length-2; i>=0; i--){
			if(ratings[i]>ratings[i+1])
				r2l[i] = r2l[i+1]+1;
		}
		for(int i=1; i<ratings.length; i++){
			max += Math.max(l2r[i], r2l[i]); 
		}
		return max;
	}
	
	public static void main(String[] args) {
		Candy obj = new Candy();
		int[] ratings = {0};
		obj.candy(ratings);
	}

}
