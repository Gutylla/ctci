/**
 * 
 */
package HardProblems;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class PageOneHard {
	//
	public boolean isNumber(String s) {
		boolean flag = false;
		try{
			int i = Integer.parseInt(s);
			flag = flag || true;
		}
		catch(NumberFormatException e){
			flag = flag || false;
		}
		try{
			Double d = Double.parseDouble(s);
			flag = flag || true;
		}
		catch(NumberFormatException e){
			flag = flag || false;
		}
		try{
			float f = Float.parseFloat(s);
			flag = false;
		}
		catch(NumberFormatException e){
			flag = flag || true;
		}
		return flag; 
	}

	//312
	public int maxCoins(int[] nums) {
		int left;
		int right;
		for(int i = 0; i<nums.length; i++){
			if(i==0) left = 1;
			else left = nums[i-1];
			if(i == nums.length-1) right = 1;
			else right = nums[i+1];
			int maxVal = left * nums[i] * right;
		}
		return 1;
	}
	public static void main(String[] args) {
		PageOneHard obj = new PageOneHard();
		System.out.println("959440.94" + obj.isNumber("959440.94"));
	}

}
