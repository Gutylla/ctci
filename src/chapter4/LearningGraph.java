/**
 * 
 */
package chapter4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class LearningGraph {

	int maxVerts = 4;
	Vertex[] vertexList;
	boolean[][] matrix;
	int[][] weightedMatrix;
	int nVerts; // current number of vertices

	public LearningGraph(){
		vertexList = new Vertex[maxVerts];
		matrix = new boolean[maxVerts][maxVerts];
		weightedMatrix = new int[maxVerts][maxVerts];
		nVerts = 0;
		//set adjacency
		for(int row=0; row<maxVerts; row++){
			for(int col=0; col<maxVerts; col++){
				matrix[row][col] = false;
			}
		}
		//set weights
		for(int row=0; row<maxVerts; row++){
			for(int col=0; col<maxVerts; col++){
				if(row == col) weightedMatrix[row][col] = 0; // will remain 0 throughout
				else weightedMatrix[row][col] = (int) Double.POSITIVE_INFINITY; // should be infinity
			}
		}
	}

	public void addVertex(char data){
		vertexList[nVerts++] = new Vertex(data);
	}

	public void addEdge(int start, int end, int weight){
		matrix[start][end] = true;
		//matrix[end][start] = true;
		weightedMatrix[start][end] = weight;
	}

	public void displayVertex(int index){
		System.out.println("Label: " + vertexList[index].label);
	}


	public void getAllAdjVertex(int v){
		for(int col = 0; col<nVerts; col++){
			if(matrix[v][col])
				displayVertex(col);
		}
	}

	public int getAdjVertex(int v){
		for(int col = 0; col<nVerts; col++){
			if(matrix[v][col] && !vertexList[col].wasVisited) return col; 
		}
		return -1;
	}

	public void reset(){
		for(int i=0; i<nVerts; i++){
			vertexList[i].wasVisited = false;
		}
	}

	/*
	 * DFS - stacks, BFS - queues
	 * begin at vertex 0
	 * RULE 1:
	 * 1. Visit the vertex
	 * 2. push it onto stack
	 * 3. mark as visited
	 * RULE 2:
	 * if can't follow RULE1, pop a vertex off stack
	 * RULE 3:
	 * if can't follow RULE1 and RULE2, otherwise DONE
	 */
	public void dfs(){
		vertexList[0].wasVisited = true;
		displayVertex(0);

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);

		while(!stack.empty()){
			int adjV = getAdjVertex((int) stack.peek());

			if(adjV == -1){
				stack.pop();
			}else{
				vertexList[adjV].wasVisited = true;
				displayVertex(adjV);
				stack.push(adjV);
			}
		}

		reset();
	}

	public void bfs(){
		vertexList[0].wasVisited = true;
		displayVertex(0);

		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(0);

		while(!queue.isEmpty()){
			int adjV = getAdjVertex((int) queue.peek());

			if(adjV == -1){
				queue.remove();
			}else{
				vertexList[adjV].wasVisited = true;
				displayVertex(adjV);
				queue.add(adjV);
			}
		}

		reset();
	}

	//Warshall's algorithm: to get transitive closure from adjacency matrix
	/*
	 * Idea: If you can get from vertex L to vertex M, and you can get from M to N, then you can get from L to N.
	 * 
	 */
	public void transitiveClosure(){
		boolean[][] closure = new boolean[nVerts][nVerts];
		boolean[][] prevClosure = matrix;
		for(int k = 0; k < nVerts; k++){
			for(int row = 0; row < nVerts; row++){
				for(int col = 0; col < nVerts; col++){
					closure[row][col] = prevClosure[row][col] || (prevClosure[row][k] && prevClosure[k][col]);
				}
			}
			prevClosure = closure;
		}
		printMatrix(prevClosure);
	}

	public void shortestPath(){
		int[][] closure = new int[nVerts][nVerts];
		int[][] prevClosure = weightedMatrix;
		for (int i = 0; i < prevClosure.length; i++) {
			for (int j = 0; j < prevClosure[i].length; j++) {
				System.out.print(prevClosure[i][j] + "   ");
			}
			System.out.println();
		}
		System.out.println("-------");
		for(int k = 0; k < nVerts; k++){
			for(int row = 0; row < nVerts; row++){
				for(int col = 0; col < nVerts; col++){
					if(row != col)
						closure[row][col] = Math.min(prevClosure[row][col], 
								prevClosure[row][k] + prevClosure[k][col]);
				}
			}
			prevClosure = closure;
		}
		for (int i = 0; i < prevClosure.length; i++) {
			for (int j = 0; j < prevClosure[i].length; j++) {
				System.out.print(prevClosure[i][j] + "   ");
			}
			System.out.println();
		}
	}

	public void printMatrix(boolean[][] mat){
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print((mat[i][j]?1:0) + "   ");
			}
			System.out.println();
		}
		System.out.println("----------------------");
	}

	public static void main(String[] args) {
		LearningGraph obj = new LearningGraph();

		obj.addVertex('a'); //0
		obj.addVertex('b'); //1
		obj.addVertex('c'); //2
		obj.addVertex('d'); //3

		obj.addEdge(1, 0, 2);
		obj.addEdge(0, 2, 3);
		obj.addEdge(3, 0, 6);
		obj.addEdge(2, 3, 1);
		obj.addEdge(2, 1, 7);

		obj.shortestPath();
		//obj.displayVertex(0);
		//		obj.getAllAdjVertex(0);
		//		System.out.println("---------dfs-------");
		//		obj.dfs();
		//		System.out.println("---------bfs-------");
		//		obj.bfs();

	}

}

class Vertex{
	char label;
	boolean wasVisited;

	public Vertex(char label){
		this.label = label;
		this.wasVisited = false;
	}
}

