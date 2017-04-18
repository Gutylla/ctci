/**
 * 
 */
package chapter1;

/**
 * @author triptibishnoi
 *
 */
public class ArraysStrings7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matrix = {{1,2,0},{0,2,1},{1,1,1}};
		ArraysStrings7 var = new ArraysStrings7();
		int rowCount = matrix.length;
		//avoid index out of bound exception
		int colCount = rowCount>0 ? matrix[0].length : 0;
		var.setZero(matrix, rowCount, colCount);
	}

	
	public void setZero( int [][] matrix, int m, int n )
	{
	    boolean[] row = new boolean[m];
	    boolean[] column = new boolean[n];
	    //maintain two arrays,
	    //one to keep track of the row
	    //other to keep track of the column
	    for( int i = 0; i < m; i++ )
	    {
	        for( int j = 0; j < n; j++ )
	        {
	            if( matrix[i][j] == 0 )
	            {
	                row[i] = true;            
	                column[j] = true;
	            }
	        }
	    }
	    //if row array has true at any index, mark that as zero in matrix
	    for( int i = 0; i < m; i++ )
	    {
	        if( row[i] )
	        {
	            for( int j = 0; j < n; j++ )
	            {
	                matrix[i][j] = 0;
	            }
	        }
	    }
	    //follow same for the column
	    for( int j = 0; j < n; j++ )
	    {
	        if( column[j] )
	        {
	            for( int i = 0; i < m; i++ )
	            {
	                matrix[i][j] = 0;
	            }
	        }
	    }

	}

}
