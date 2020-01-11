package ConnectedComponent.FordFulkerson;

import java.util.LinkedList;
import java.util.Queue;

public class FordFulkerson {
	private boolean[] marked;
	private Edge[] edgeTo;
	private double valueMaxFlow;
	
	public FordFulkerson(FlowNetwork flowNetWork, Vertex s, Vertex t) {
		while (hasAugmeningPath(flowNetWork, s, t)) {
			double min = Double.POSITIVE_INFINITY;
			
			for (Vertex v = t; v != s; v = edgeTo[v.getId()].getOther(v)) {
				min = Math.min(min, edgeTo[v.getId()].getResidualCapacity(v));
			}
			
			for (Vertex v = t; v != s; v = edgeTo[v.getId()].getOther(v)) {
				edgeTo[v.getId()].addResidualFlowTo(v, min);
			}
			
			this.valueMaxFlow += min;
		}
	}
	
	private boolean hasAugmeningPath(FlowNetwork flowNetWork, Vertex s, Vertex t) {
		edgeTo = new Edge[flowNetWork.getNumOfVertices()];
		marked = new boolean[flowNetWork.getNumOfVertices()];
		
		Queue<Vertex> queue = new LinkedList<>();
		queue.add(s);
		marked[s.getId()] = true;
		
		while (!queue.isEmpty() && !marked[t.getId()]){
			Vertex v = queue.remove();
			
			for (Edge edge : flowNetWork.getAdjaciesList(v)) {
				Vertex o = edge.getOther(v);
				
				if(edge.getResidualCapacity(o) > 0) {
					if(!marked[o.getId()]) {
						edgeTo[o.getId()] = edge;
						marked[o.getId()] = true;
						queue.add(o);
					}
				}
			}
		}
		
		return marked[t.getId()];
	}
	
	public boolean isInCut(int index) {
		return marked[index];
	}
	
	public double getMaxFlow() {
		return this.valueMaxFlow;
	}

	
}
