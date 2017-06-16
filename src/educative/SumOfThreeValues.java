/**
 * 
 */
package educative;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class SumOfThreeValues {

	public int[] method(int[] arr, int sum){ // assuming arr is sorted in ascending order
		int[] out = new int[3];
		
		int i=0, j=0, k=arr.length-1; 
		while(i<arr.length && j<=k){
			if(j==k){
				j=0;
				k=arr.length-1;
				i++;
				continue;
			}
			if(i==j){
				j++;
				continue;
			}
			if(i==k){
				k--;
				continue;
			}
			int diff = arr[i] + arr[j] + arr[k] - sum;
			if(diff == 0){
				out[0] = i;
				out[1] = j;
				out[2] = k;
				return out;
			}
			else if(diff > 0)
				k--;
			else if(diff < 0)
				j++;
		}
		
		return out;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumOfThreeValues obj = new SumOfThreeValues();
		int[] out = obj.method(new int[]{1,2,3,4,5,7,8}, 6);
		System.out.println(out[0]);
		System.out.println(out[1]);
		System.out.println(out[2]);
	}

}
