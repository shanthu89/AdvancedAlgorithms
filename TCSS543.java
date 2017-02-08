import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TCSS543 {
	//class to define Min and Max range for the 4 groups
	private static class Range {
		Range(double min, double max) {
			this.Max = max;
			this.Min = min;
		}
		double Min;
		double Max;
	}
	
	public static void main(String[] args) {
		List<Range> ranges = new ArrayList<Range>(4);
		//group 1 range --> 0.73 to 0.82
		ranges.add(new Range(0.73, 0.82));
		//group 2 range --> 0.61 to 0.72
		ranges.add(new Range(0.61, 0.72));
		//group 3 range --> 0.44 to 0.59
		ranges.add(new Range(0.44, 0.59));
		//group 4 range --> 0.26 to 0.34
		ranges.add(new Range(0.26, 0.34));
		int maxVertices = 500;//change this variable to run for desired number of vertices.
		System.out.println("VertexCount,GroupNumber,Colors,Time");
		// generate graph with vertices 10,20,30 etc.
		for (int numVertices = 10; numVertices <= maxVertices; numVertices += 10) {
			//generate graph for each of the 4 groups
			for (int groupNum = 0; groupNum < 4; groupNum++) {
				Range groupRange = ranges.get(groupNum);
				int graphCount = 100;
				//list to maintain graphs created for each group.
				List<Graph> graphs = new ArrayList<Graph>(graphCount);
				// generate 100 graphs for each number of vertices in all 4 groups.
				for (int j = 0; j < graphCount; j++) {
					// generate random number for each group
					double density = generateRandomNum(groupRange.Min, groupRange.Max);
					graphs.add(RandomGraphGenerator.BuildRandomGraph(numVertices, density));
				}
				
				// Run DSatur algorithm and color graphs
				int numColors = 0;
				long startTime = System.currentTimeMillis();
				for (Graph graph: graphs) {
					DSatur algo = new DSatur(graph);
					algo.colorGraph();
					numColors += algo.getColorCount();
					//System.out.println("Number of colors used: " + algo.getColorCount());
				}
				long stopTime = System.currentTimeMillis();
				long elapsedTime = stopTime - startTime;
				//System.out.println(String.format("NumVertices: %d, GroupNum: %d, NumColors: %f, ElapsedTime :%d milliseconds",
				//		numVertices, groupNum, 1.0 * numColors/graphCount, elapsedTime));
				System.out.println(String.format("%d,%d,%.3f,%.3f", numVertices, groupNum+1, 1.0*numColors/graphCount, 1.0*elapsedTime/graphCount));
			}
		}
	}
	//function to generate random number
	private static double generateRandomNum(Double Min, Double Max) {
		double randomNum = 0;
		Random random = new Random();
		randomNum = random.nextDouble() * ((Max - Min) + 0.001) + Min;
		randomNum = (double) Math.round(randomNum * 100) / 100;
		return randomNum;

	}
	/*
	public static void callRandomGraphGeneration(Integer grpNumber,int numVertices,double density){
		RandomGraphGenerator randomGraph = new RandomGraphGenerator();
		Graph myGraph = randomGraph.BuildRandomGraph(numVertices,
				density);
		if(graphMap.get(grpNumber)== null){
			LinkedList<Graph> grpList = new LinkedList<>();
			graphMap.put(grpNumber, grpList);
		}
		graphMap.get(grpNumber).add(myGraph);
		
	}*/
	
	
}
