/**
 * 
 */
package LeetCodeProblems;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class MaxPointsOnLine {

	public int maxPoints(Point[] points) {
		if(points.length == 0) return 0;
		if(points.length == 1) return 1;
		
		int j = 0;
		while(j<points.length){
			if(points[0].x == points[j].x && points[0].y == points[j].y)
				j++;
			else
				break;
		}
		
		if(j == points.length) return j;
		
		boolean flag = false;
		if(points[0].x == points[j].x)
			flag = true;

		int count = 0;
		for(int i=0; i<points.length; i++){
			if(flag){
				if(points[i].x == points[0].x)
					count += 1;
			}
			else{
				if((points[i].y - points[0].y) * (points[j].x-points[0].x) == (points[i].x - 1) * (points[j].y-points[0].y))
					count += 1;
			}
		}

		return count;
	}


	private double slope(Point p1, Point p2){
		return ((p2.x-p1.x) == 0) ? -1 : ((double)(p2.y-p1.y)/(double)(p2.x-p1.x));
	}

	private double b(double m, Point p1){
		return ((double)(p1.y)-m*(double)(p1.x));
	}

	public static void main(String[] args) {
		MaxPointsOnLine obj = new MaxPointsOnLine();
		Point[] points = new Point[4];
		points[0] = new Point(3,1);
		points[1] = new Point(12,3);
		points[2] = new Point(3,1);
		points[3] = new Point(-6,-1);
		System.out.println(obj.maxPoints(points));

	}

}

class Point {
	int x;
	int y;
	Point() { x = 0; y = 0; }
	Point(int a, int b) { x = a; y = b; }
}
