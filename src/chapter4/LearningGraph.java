/**
 * 
 */
package chapter4;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class LearningGraph {

	int maxVerts = 5;
	Vertex[] vertexList;
	boolean[][] matrix;
	int nVerts; // current number of vertices

	public LearningGraph(){
		vertexList = new Vertex[maxVerts];
		matrix = new boolean[maxVerts][maxVerts];
		nVerts = 0;
		//set adjacency
		for(int row=0; row<maxVerts; row++){
			for(int col=0; col<maxVerts; col++){
				matrix[row][col] = false;
			}
		}
	}

	public void addVertex(char data){
		vertexList[nVerts++] = new Vertex(data);
	}

	public void addEdge(int start, int end){
		matrix[start][end] = true;
		matrix[end][start] = true;
	}

	public void displayVertex(int index){
		System.out.println("Label: " + vertexList[index].label);
	}

	/*
	 * DFS - stacks
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

	public static void main(String[] args) {
		LearningGraph obj = new LearningGraph();
		
		obj.addVertex('a');
		obj.addVertex('b');
		obj.addVertex('c');
		obj.addVertex('d');
		obj.addVertex('e');
		
		obj.addEdge(0, 1);
		obj.addEdge(0, 3);
		obj.addEdge(1, 2);
		obj.addEdge(1, 3);
		obj.addEdge(2, 4);
		obj.addEdge(3, 4);
		
		System.out.println(obj.getAdjVertex(0));
		System.out.println("---------dfs-------");
		obj.dfs();
		System.out.println("---------bfs-------");
		obj.bfs();
		
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

