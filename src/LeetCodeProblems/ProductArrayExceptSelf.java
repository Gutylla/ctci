/**
 * 
 */
package LeetCodeProblems;

import java.util.Arrays;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class ProductArrayExceptSelf {

	public int[] productExceptSelf(int[] nums) {
		int[] out = new int[nums.length];

		if(nums.length == 0) return out;
		
		Arrays.fill(out, 1);
		
		for(int i=1; i<nums.length; i++){
			out[i] = out[i-1] * nums[i-1];
		}

		int suffix = 1;
		for(int i=nums.length-1; i>=0; i--){
			out[i] = out[i] *  suffix;
			suffix = suffix * nums[i];
		}
		
		return out;
	}

	public static void main(String[] args) {
		ProductArrayExceptSelf obj = new ProductArrayExceptSelf();
		int[] nums = {1,2,3,4};
				//	 {1,1,8,6};
		
		obj.productExceptSelf(nums);
	}

}
