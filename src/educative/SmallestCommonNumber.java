/**
 * 
 */
package educative;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class SmallestCommonNumber {

	public int findLeastCommonNumber(int[] arr1, int[] arr2, int[] arr3){
		int i = 0;
		int j = 0;
		int k = 0;
		while(i<arr1.length || j<arr2.length || k<arr3.length){
			if(arr1[i] == arr2[j] && arr1[i] == arr3[k])
				return arr1[i];
			else{
				if(arr1[i] < arr2[j] && arr1[i] < arr3[k])
					i++;
				else if(arr2[j] < arr1[i] && arr2[j] < arr3[k])
					j++;
				else if(arr3[k] < arr2[j] && arr3[k] < arr1[i])
					k++;
			}
		}
		return -1;
	}
	
	
	public void moveZeroToLeft(int[] a){
		if(null == a) return;
		int read = a.length - 1;
		int write = a.length - 1;
		while(read >= 0){
			if(a[read] != 0 ){
				a[write] = a[read];
				write--;
			}
			read--;
		}
		while(write >= 0){
			a[write] = 0;
			write--;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
