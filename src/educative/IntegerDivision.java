/**
 * 
 */
package educative;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class IntegerDivision {

	public int divide(int divident, int divisor){
		if(divisor == 0) return -1;
		if(divident == divisor) return 1;
		if(divident < divisor) return 0;
		if(divisor == 1) return divident;

		int quotient = 1;
		int temp = divisor;
		
		while(temp < divident){
			temp <<= 1;
			quotient <<= 1;
		}
		if(temp > divident){
			temp >>= 1;
			quotient >>= 1;
			return quotient + divide(divident-temp, divisor);
		}
		return quotient;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerDivision obj = new IntegerDivision();
		System.out.println(obj.divide(12, 4));
	}

}
