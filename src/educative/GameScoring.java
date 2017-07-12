/**
 * 
 */
package educative;


/**
 * @author TriptiAshishUpadhyay
 *
 */
public class GameScoring {

	public void scoreWays(int[] a, int n, int curr, int count){
		for(int i=0; i<a.length; i++){
			if(curr + a[i] == n)
				count += 1;
			else if(curr + a[i] < n){
				curr += a[i];
				scoreWays(a, n-a[i], curr, count);
			}
		}
	}

	public char method(String s){
		char[] ch = s.toCharArray();
		for(int i=0; i<s.length(); i++){
			if(s.indexOf(ch[i]) == s.lastIndexOf(ch[i]))
				return ch[i];
		}
		return '_';
	}

	public int[][] rotateImage(int[][] a) {
		 if(a == null || a.length<1)
		        return a;
		    int n = a.length;
		    for(int r=0; r<n/2; r++){
			        for(int c=0; c<Math.ceil(((double) n) / 2.); c++){
			            int temp = a[r][c];
			            a[r][c] = a[n-c-1][r];
			            a[n-c-1][r] = a[n-r-1][n-c-1];
			            a[n-r-1][n-c-1] = a[c][n-r-1];
			            a[c][n-r-1] = temp;
			        }
			    }
		return a;
	}

	public boolean sudoku2(char[][] grid) {
		for(int r=0; r<9; r++){
			for(int c=0; c<9; c++){
				if(grid[r][c] == '.')
					continue;
				//check row
				for(int i=0; i<9; i++){
					if(i!=c && grid[r][i] == grid[r][c])
						return false;
				}
				//check column
				for(int i=0; i<9; i++){
					if(i!=r && grid[i][c] == grid[r][c])
						return false;
				}
				//check submatrix
				int sr = start(r);
				int er = end(r);
				int sc = start(c);
				int ec = end(c);
				for(int i=sr; i<=er; i++){
					for(int j=sc; j<=ec; j++){
						if(i!=r && j!=c && grid[i][j] == grid[r][c])
							return false;
					}
				}
			}
		}
		return true;
	}

	int start(int n){
		if(n%3 == 0)
			return n;
		else if(n%3 == 1)
			return n-1;
		else
			return n-2;
	}

	int end(int n){
		if(n%3 == 0)
			return n+2;
		else if(n%3 == 1)
			return n+1;
		else
			return n;
	}

	public boolean isCryptSolution(String[] crypt, char[][] solution) {
		int val1 = getVal(crypt[0],solution);
		int val2 = getVal(crypt[1],solution);
		int val3 = getVal(crypt[2],solution);
		if(val1 == -1 || val2 == -1 || val3 == -1)
			return false;
		return (val3 == val1 + val2);
	}

	int getVal(String s, char[][] sol){
		String out = "";
		for(int i=0; i<s.length(); i++){
			char ch = s.charAt(i);
			for(int r=0; r<sol.length; r++){
				if(sol[r][0] == ch)
					out += sol[r][1];
			}
		}
		if(out.charAt(0) == '0')
			return -1;
		return Integer.valueOf(out);
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameScoring obj = new GameScoring();

//		char[][] solution = {{'O', '0'},
//				{'M', '1'},
//				{'Y', '2'},
//				{'E', '5'},
//				{'N', '6'},
//				{'D', '7'},
//				{'R', '8'},
//				{'S', '9'}};
//		obj.isCryptSolution(new String[]{"SEND","MORE", "MONEY"}, solution);
//
//		char[][] a = {{'.', '.', '.', '1', '4', '.', '.', '2', '.'},
//				{'.', '.', '6', '.', '.', '.', '.', '.', '.'},
//				{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//				{'.', '.', '1', '.', '.', '.', '.', '.', '.'},
//				{'.', '6', '7', '.', '.', '.', '.', '.', '9'},
//				{'.', '.', '.', '.', '.', '.', '8', '1', '.'},
//				{'.', '3', '.', '.', '.', '.', '.', '.', '6'},
//				{'.', '.', '.', '.', '.', '7', '.', '.', '.'},
//				{'.', '.', '.', '5', '.', '.', '.', '7', '.'}};
//
//		obj.sudoku2(a);
		
		int[][] a = {{1,2},{3,4}};
		obj.rotateImage(a);

//		obj.method("abacabad");
//		obj.scoreWays(new int[]{1,2,3}, 5, 0, 0);
	}

}
