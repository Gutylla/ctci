/**
 * 
 */
package CodeFights;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class MonuProblem {

	public void method(int n){
		if(n < 1)
			return;
		System.out.println(n);
		method(n-1);
		// 3 1 2 1 3 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MonuProblem obj = new MonuProblem();
		obj.method(3);
	}

}
