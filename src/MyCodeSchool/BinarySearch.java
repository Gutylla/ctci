/**
 * 
 */
package MyCodeSchool;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class BinarySearch {

	int[] index;
	
	public BinarySearch(){
		index = new int[2];
	}
	
	public int binarySearch(int[] nums, int target, int start, int end, int count){
		if (start < end) {
			int mid = start + (end - start) / 2; 
			if (target < nums[mid]) {
				return binarySearch(nums, target, start, mid, count);

			} else if (target > nums[mid]) {
				return binarySearch(nums, target, mid+1, end, count);

			} else {
				return count + 1;  
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
	
	public static void main(String[] args) {
		BinarySearch obj = new BinarySearch();
		int[] nums = {1,2,5,5,5,5,5,6,7};
					//0,1,2,3,4,5,6,7,8
		System.out.println(obj.binarySearch(nums, 7, 0, 8,0));
	}

}
