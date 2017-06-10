/**
 * 
 */
package educative;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class FindMissingNumber {

	public int find(int[] arr, int n){
		int sum = 0;
		for(int i=0; i<arr.length; i++)
			sum += arr[i];
		int sumExpected = (n * (n+1)) / 2;
		return sumExpected - sum;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindMissingNumber obj = new FindMissingNumber();
		int[] arr = {1,2,3,4,5,6,7,8,9};
		System.out.println(obj.find(arr, 10));
	}

}
