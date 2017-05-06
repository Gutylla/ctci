/**
 * 
 */
package PageTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class InsertInterval {

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if(intervals.size() == 0) {
			intervals.add(newInterval);
			return intervals;
		}
		int startIndex = -1, endIndex = -1;
		for(int i=0; i<intervals.size(); i++){
			if(newInterval.start >= intervals.get(i).start && newInterval.start <= intervals.get(i).end){ 
				startIndex = i;
				endIndex = i;
			} else{
				if(newInterval.start > intervals.get(i).end)
					startIndex = i + 1;
				if(newInterval.end >= intervals.get(i).start)
					endIndex = i;
			}
		}
		if(startIndex > endIndex){
			intervals.add(startIndex,newInterval);
		}
		else if(startIndex > -1 && endIndex > -1){
			intervals.add(startIndex, new Interval(
					(newInterval.start < intervals.get(startIndex).start) ? newInterval.start : intervals.get(startIndex).start,
					(newInterval.end > intervals.get(endIndex).end) ? newInterval.end : intervals.get(endIndex).end));
			for(int j = startIndex+1, count = endIndex+1-startIndex; count>0; count--)
				intervals.remove(j);
		}
		else if(startIndex == -1 && endIndex > -1){
			intervals.add(0, new Interval(newInterval.start, 
					(newInterval.end > intervals.get(endIndex).end) ? newInterval.end : intervals.get(endIndex).end));
			for(int j = 1, count = endIndex+1; count>0; count--)
				intervals.remove(j);
		}
		else if(startIndex == -1 && endIndex == -1){
			intervals.add(0, newInterval);
		}
		return intervals;
	}

	public void printIntervals(List<Interval> intervals){
		for(int i=0; i<intervals.size(); i++)
			System.out.println("["+ intervals.get(i).start+", "+intervals.get(i).end+"]");
		System.out.println("----------------");
	}

	public static void main(String[] args) {
		InsertInterval obj = new InsertInterval();
		List<Interval> intervals = new ArrayList<>();
		Interval newInterval = new Interval(6,6);
		intervals.add(new Interval(3,5));
//		intervals.add(new Interval(3,5));
//		intervals.add(new Interval(6,7));
//		intervals.add(new Interval(8,10));
		intervals.add(new Interval(12,15));
		obj.printIntervals(intervals);
		obj.printIntervals((obj.insert(intervals, newInterval)));
	}

}

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}