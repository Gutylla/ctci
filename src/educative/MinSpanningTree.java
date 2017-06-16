/**
 * 
 */
package educative;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class MinSpanningTree {

	int maxVerts;
	int[][] matrix;
	ArrayList<Vertex> vertexList;

	/**
	 * 
	 */
	public MinSpanningTree(int maxVerts) {
		// TODO Auto-generated constructor stub
		vertexList = new ArrayList<>();
		this.maxVerts = maxVerts;
		matrix = new int[maxVerts][maxVerts];
	}

	public void addVertex(char data){
		vertexList.add(new Vertex(data));
	}

	public void addEdge(int start, int end, int weight){
		matrix[start][end] = weight;
	}

	//to find minimum spanning tree
	public void primsAlgo(){
		Vertex curr = vertexList.get(0);
		Stack<Vertex> stack = new Stack<>();
		stack.push(curr);
		int currIndex = 0;

		int edges = 0;
		while(edges < maxVerts){
			int min = Integer.MAX_VALUE;
			for(int col = 0; col<maxVerts; col++){
				if(!vertexList.get(currIndex+1).visited && min > matrix[currIndex][col]){
					min = matrix[currIndex][col];
					stack.push(vertexList.get(currIndex+1));
				}
			}
		}
	}

	//to find minimum spanning tree
	public void kruskalsAlgo(){

	}

	public void dijkstrasAlgo(){

	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Vertex{
	char label;
	boolean visited;

	/**
	 * 
	 */
	public Vertex(char data) {
		// TODO Auto-generated constructor stub
		this.label = data;
		this.visited = false;
	}
}
