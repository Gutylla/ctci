/**
 * 
 */
package educative;

import java.util.ArrayList;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class MakeColumnAndRowZero {

	public int[][] method(int[][] in){
		ArrayList<Integer> rows = new ArrayList<>();
		ArrayList<Integer> cols = new ArrayList<>();

		int rowsCount = in.length;
		int colsCount = rowsCount>0 ? in[0].length : 0;
		for(int row=0; row<rowsCount; row++){
			for(int col=0; col<colsCount; col++){
				if(in[row][col] == 0){
					if(!rows.contains(row)) rows.add(row);
					if(!cols.contains(col)) cols.add(col);
				}
			}
		}

		for(int i=0; i<rows.size(); i++){
			for(int col=0; col<colsCount; col++)
				in[rows.get(i)][col] = 0;
		}

		for(int i=0; i<cols.size(); i++){
			for(int row=0; row<rowsCount; row++)
				in[row][cols.get(i)] = 0;
		}

		return in;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
