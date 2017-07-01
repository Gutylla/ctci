/**
 * 
 */
package educative;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class MaxSumSubseq {
	
	public int method(int[] in){
		int len = in.length;
		if(len<1) return -1;
		int[] res = new int[len];
		int i=1;
		res[0] = in[0];
		while(i<len){
			res[i] = Math.max(res[i-1], in[i]);
			i++;
			if(i<len){
				res[i] = Math.max(res[i-1], res[i-2]+in[i]);
				i++;
			}
		}
		return res[len-1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxSumSubseq obj = new MaxSumSubseq();
		obj.method(new int[]{1,-1,6,-4,2,2,3});
	}

}
