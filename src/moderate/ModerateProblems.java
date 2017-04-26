/**
 * 
 */
package moderate;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class ModerateProblems {

	//Problem 16.1
	public void numberSwapper(int var1, int var2){
		System.out.println("before: var1- "+ var1 + ", var2- "+var2);
		var1 = var1 + var2;
		var2 = var1 - var2;
		var1 = var1 - var2;
		System.out.println("after: var1- "+ var1 + ", var2- "+var2);
	}
	
	public static void main(String[] args) {
		ModerateProblems obj = new ModerateProblems();
		obj.numberSwapper(4, 10);
	}

}
