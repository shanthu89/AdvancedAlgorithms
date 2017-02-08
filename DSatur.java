import java.util.Collection;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;

public class DSatur {
	private Graph graph;
	private SortedSet<Integer> colors;
	private Collection<Vertex> colorlessVertices;
	/*constructor created whenever a graph is to be colored.
	Tree Set to store the colors used in sorted order.
	colorlessVertices will initially have collection of all vertices in graph and remove them from list once they are colored.
	*/
	public DSatur (Graph graph) {
		this.graph = graph;
		colors = new TreeSet<Integer>();
		colorlessVertices = graph.getVertices();
	}
	//get total number of colors used.
	public int getColorCount() {
		return colors.size();
	}
	//function to compute saturation degree for list of vertices.
	private void calculateSaturationDegree(Collection<Vertex> inputVertices) {
		//System.out.println("Calculating saturated degree for vertices: " + inputVertices.size());
		for (Vertex v: inputVertices) {
			Collection<Vertex> adjacentVertices = graph.getAdjacentVertices(v);
			SortedSet<Integer> adjColorCodes = new TreeSet<Integer>();
			for (Vertex adjVertex: adjacentVertices) {
				int color = adjVertex.getColor();
				if (color > 0) {
					adjColorCodes.add(adjVertex.getColor());
				}
			}
			v.setSatDegree(adjColorCodes.size());
		}
	}
	//algorithm that colors the graph using Brelaz algorithm
	public void colorGraph() {
		//calculateSaturationDegree(colorlessVertices);
		while (colorlessVertices.size() > 0) {
			//priority queue will store the vertices to be colored.
			PriorityQueue<Vertex> PQNode = new PriorityQueue<Vertex>(colorlessVertices);
			//PriorityQueue<Vertex> printTemp = new PriorityQueue<Vertex>(PQNode);
			//displayPQ(printTemp); // this PQ will be deleted
			
			//pick node to be colored
			Vertex selectedVertex = PQNode.remove();
			//System.out.print("Coloring vertex: "+selectedVertex.getLabel());
			
			/*compute colors of adj vertices to color vertex with least possible color.
			 *add all colors of the adj vertices in adjColorCodes sortedSet.
			 */
			
			Collection<Vertex> adjacentVertices = graph.getAdjacentVertices(selectedVertex);
			SortedSet<Integer> adjColorCodes = new TreeSet<Integer>();
			for (Vertex adjVertex: adjacentVertices) {
				int color = adjVertex.getColor();
				if (color > 0) {
					adjColorCodes.add(adjVertex.getColor());
				}
			}
			
			/* computing least possible color.
			 * tempColors will have list of all colors used in graph already.
			 * remove all adjVertices color from tempColors. 
			 * If all colors are used already we will assign new color , else pick first element from tempColors(which is least color)
			 */
			SortedSet<Integer> tempColors = new TreeSet<Integer>(colors);
			tempColors.removeAll(adjColorCodes);
			int newColor;
			if (tempColors.size() > 0) {
				newColor = tempColors.first();
			} else {
				newColor = colors.size()+1;
				colors.add(newColor);
			}
			selectedVertex.setColor(newColor);
			//System.out.println(", Color: "+newColor);
			
			//remove the vertex colored from list
			colorlessVertices.remove(selectedVertex);
			
			/*recompute saturation degree for adj vertices of 
			 * the selected vertices alone as other vertices sat degree will be same.
			 */
			calculateSaturationDegree(graph.getAdjacentVertices(selectedVertex));
		}
		//add all vertices to Priority queue to compute the Adj and Sat degree
		//Collection<Vertex> vertices = graph.getVertices();
		
/*		
		//Set color = 1 for the vertex with max adjacency degree
	 	int newColor = colors.last()+1;
		PQNode.peek().setColor(newColor);
		colors.add(newColor);
		
		//compute Saturation degree for all vertices
		//Set<Entry<String,LinkedList<Vertex>>> adjSet = adjVertices.entrySet();
		
		calculateSaturationDegree();

		//view sat degree of all vertices
		Set<Entry<String, Vertex>> vertexList = vertices.entrySet();
		for (Entry<String, Vertex> i : vertexList) {
			String vertexLbl = i.getKey();
			Vertex v = i.getValue();
			System.out.print(vertexLbl + " sat degree --> ");
			System.out.println(v.getSatDegree());

		}
		
		System.out.println(PQNode.peek());
		displayPQ(PQNode);
		//pick vertex with max saturation degree
		//System.out.println(PQNode.peek());
*/		
		
	}
	//helper function to view elements in PQ. 
	public void displayPQ(PriorityQueue<Vertex> PQNode){
		//view all elements in PQ
		//System.out.println("elements in PQ");
		/*
		for (Vertex v: PQNode) {
			System.out.println(String.format("Label: %s, Adj: %d, Sat: %d",
					v.getLabel(), v.getAdjDegree(), v.getSatDegree()));
		}*/
				
				while(PQNode.size()>=1){
					Vertex v = PQNode.remove();
					System.out.println(String.format("Label: %s, Adj: %d, Sat: %d",
							v.getLabel(), v.getAdjDegree(), v.getSatDegree()));
					/*
					System.out.print(PQNode.peek()+ ": label " + PQNode.peek().getLabel());
					System.out.print(" adj degree " + PQNode.peek().getAdjDegree());
					System.out.print(" sat degree " + PQNode.remove().getSatDegree());
					
					System.out.println();
					*/
				}
				
	}

	
}
