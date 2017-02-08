import java.util.ArrayList;




public class RandomGraphGenerator {
	public static Graph BuildRandomGraph(int numVertices,double density) {
		
		//generate list of vertices
		ArrayList<String> input = new ArrayList<>();
		for(Integer i=1;i<=numVertices;i++){
			input.add(i.toString());
		}
		
		//create graph object passing the vertices.
		Graph myGraph = new Graph(input.iterator());
		
		//add edge depending on density. 
		//int count=0;
		for(Integer i=1;i<=numVertices;i++){
			for(Integer j=i+1;j<=numVertices;j++){
				
				double randomNum = Math.random();
				randomNum = (double) Math.round(randomNum * 100) / 100;
				//System.out.println(randomNum);
				if(randomNum < density){
					myGraph.addEdge(i.toString(),j.toString() );
					//count++;
				}
			}
		}
		//System.out.println("edges added " + count);
		myGraph.computeAdjacentDegree();
		//myGraph.displayGraph();
		//System.out.println("Graph created");
		
		/*
		double randomNum = Math.random();
		randomNum = (double) Math.round(randomNum * 100) / 100;
		System.out.println(randomNum);
		
		double Min = 0.26;
		double Max = 0.34;	
		double testRanNo = Min + (Math.random() * ((Max - Min) + 0.001 ));
		testRanNo = (double) Math.round(testRanNo * 100) / 100;
		System.out.print("method-2 ");
		System.out.println(testRanNo);*/
		
		
		return myGraph;
		
	}
	
	
}
