/**
 * 
 */
package educative;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class SearchInAMatrix {

	public int[] method(int[][] in, int val){
		int rowsCount = in.length;
		int colsCount = rowsCount>0 ? in[0].length : 0;

		int row = 0; 
		int col = colsCount-1;
		while(row<rowsCount && col>=0){
			if(in[row][col] == val)
				return new int[]{row,col};
			else if(val > in[row][col])
				row++;
			else if(val < in[row][col])
				col--;
		}

		return null;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchInAMatrix obj = new SearchInAMatrix();
		int[][] mat = {{2,4,9,13},{3,5,11,18},{6,8,16,21},{9,11,20,25}};
		int[] out = obj.method(mat, 90);
		if(out != null)
			System.out.println(out[0] + ", " + out[1]);
		else
			System.out.println("cant find!!");
	}

}
