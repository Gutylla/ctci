/**
 * 
 */
package educative;

/**
 * @author TriptiAshishUpadhyay
 *
 *	Fibonacci number for +ve and -ve numbers
 *				 n+1
 * Fib(-n) = (-1)	 * Fib(n)
 */
public class FibonacciNumber {

	public int fib(int n){
		if(n==0 || n==1)
			return n;
		int n1 = 1;
		int n2 = 0;
		int result = 0;

		for(int i=2; i<=Math.abs(n); i++){
			result = n1 + n2;
			n2 = n1;
			n1 = result;
		}

		if(n < 0 && Math.abs(n) % 2 == 0)
			return (0 - result);

		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FibonacciNumber obj = new FibonacciNumber();
		System.out.println(obj.fib(5));
	}

}
