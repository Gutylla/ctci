/**
 * 
 */
package educative;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class DerivativeOfPolynomial {

	public int[] findDerivative(int[] pol){
		if(pol.length < 2) return new int[]{0};

		int[] out = new int[pol.length-1];
		for(int i=1; i<pol.length; i++){
			out[i-1] = pol[i] * i;
		}
		return out;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DerivativeOfPolynomial obj = new DerivativeOfPolynomial();
		int[] out = obj.findDerivative(new int[]{1,3,2});
		for(int i=0; i<out.length; i++)
			System.out.println(out[i]);
	}

}
