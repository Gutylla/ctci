/**
 * 
 */
package educative;

import java.util.ArrayList;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class MergeIntervals {

	public ArrayList<Interval> merge(ArrayList<Interval> in){
		ArrayList<Interval> out = new ArrayList<Interval>();
		for(int i=0, j=0; i<in.size();){
			if(out.isEmpty())
				out.add(j, in.get(i++));
			else{
				if(in.get(i).start <= out.get(j).end){
					if(out.get(j).end < in.get(i).end)
						out.get(j).end = in.get(i++).end;
					else
						i++;
				}
				else
					out.add(++j, in.get(i++));
			}
		}
		return out;
	}

	public static void main(String[] args) {
		ArrayList<Interval> in = new ArrayList<Interval>();
		in.add(new Interval(1,5));
		in.add(new Interval(3,7));
		in.add(new Interval(4,6));
		in.add(new Interval(6,8));
		in.add(new Interval(10,12));
		in.add(new Interval(11,15));
		MergeIntervals obj = new MergeIntervals();
		ArrayList<Interval> out = obj.merge(in);
		for(int i=0; i<out.size(); i++)
			System.out.println("(" + out.get(i).start + ", " + out.get(i).end + ")");
	}

}

class Interval{
	int start;
	int end;

	public Interval(int s, int e){
		start = s;
		end = e;
	}
}