/**
 * 
 */
package educative;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class SquareRoot {

	//iterative
	public double findSR(double num){
		double low = 0, high = 1 + num/2;
		while(low < high){
			double mid = (low + high) / 2;
			double s = mid * mid;
			double diff = Math.abs(s - num);
			if(diff <= 0.00001)
				return Math.round(mid * 100.00) / 100.00;
			else if(s < num)
				low = mid;
			else if(s > num)
				high = mid;
		}
		return -1;
	}

	//recursive
	public double root(double num, double low, double high){
			double mid = (low + high) / 2;
			double s = mid * mid;
			double diff = Math.abs(s - num);
			if(diff <= 0.00001)
				return Math.round(mid * 100.00) / 100.00;
			else if(s < num)
				return root(num, mid, high);
			else if(s > num)
				return root(num, low, mid);
		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SquareRoot root = new SquareRoot();
		System.out.println(root.findSR(10));
		System.out.println(root.root(10, 0, 6));
	}

}
