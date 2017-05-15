/**
 * 
 */
package LeetCodeProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class PascalsTriangle {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		if(numRows > 0){
			List<Integer> outList = new ArrayList<Integer>();
			outList.add(1);

			List<Integer> prevList;
			output.add(outList);
			prevList = outList;
			while(numRows > 1){
				outList = new ArrayList<Integer>();
				outList.add(1);
				for(int i=0; i<prevList.size()-1; i++){
					outList.add(prevList.get(i)+prevList.get(i+1));
				}
				outList.add(1);
				output.add(outList);
				prevList = outList;
				numRows--;
			}
		}
		return output;
	}
	public static void main(String[] args) {
		PascalsTriangle obj = new PascalsTriangle();
		obj.generate(5);
	}

}
