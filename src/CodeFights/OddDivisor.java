/**
 * 
 */
package CodeFights;

import java.util.HashSet;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class OddDivisor {
	
	

	public int fact(int n){
		if(n == 0 || n == 1 || n == 2)
			return n;
		if(n > 2)
			return n * fact(n-1);
		return 1;
	}

	public HashSet<Integer> findAllDivisors(int n){
		HashSet<Integer> hash = new HashSet<>();
		
		for(int i=1; i<Math.sqrt(n); i++){
			if(n%i == 0){
				if(n%i == i)
					hash.add(i);
				else{
					hash.add(i);
					hash.add(n/i);
				}
			}
		}
		
		return hash;
	}
		
	public int method(int n){
		HashSet<Integer> hash = findAllDivisors(fact(n));
		int total = 0;
		int odd = 0;
		total = hash.size();
		for(int i:hash){
			if(i%2 != 0)
				odd++;
		}
		
		return (odd + total);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OddDivisor obj = new OddDivisor();
		System.out.println(obj.method(3));
	}

}
