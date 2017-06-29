/**
 * 
 */
package educative;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class LevenshteinDistance {

	public void dosom() {
		int value = 9 + 9;
		int value2 = 10 + 9;	
		boolean attempt = value2 > value;
		while (attempt == true){
			System.out.println("egal");
			value2 = value2 - 1; // Also wrote slightly different version 	value = value + 1;
		}
	}
	
	public int method(String s1, String s2){
		int len1 = s1.length(); // row
		int len2 = s2.length(); // col

		if(s1 == s2)
			return 0;
		if(len1 == 0)
			return len2;
		if(len2 == 0)
			return len1;

		int[][] matrix = new int[len1+1][len2+1];

		for(int i=0; i<len2+1; i++)
			matrix[0][i] = i;

		for(int i=0; i<len1+1; i++)
			matrix[i][0] = i;

		int cost;
		for(int r=1; r<len1+1; r++){
			for(int c=1; c<len2+1; c++){
				if(s1.charAt(r-1) != s2.charAt(c-1))
					cost = 1;
				else
					cost = 0;
				matrix[r][c] = Math.min(matrix[r-1][c-1] + cost, Math.min(matrix[r][c-1] + 1, matrix[r-1][c] + 1));
			}
		}

		return matrix[len1][len2];
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LevenshteinDistance obj = new LevenshteinDistance();
		obj.dosom();
		//System.out.println(obj.method("katty", "fitaty"));
	}

}
