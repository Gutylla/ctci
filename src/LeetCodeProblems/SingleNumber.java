/**
 * 
 */
package LeetCodeProblems;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class SingleNumber {

	public int singleNumber(int[] nums) {
		if(nums.length < 1) return -1;
		int out = nums[0];
		for(int i =1; i<nums.length; i++)
			out = out ^ nums[i];
		return out;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
