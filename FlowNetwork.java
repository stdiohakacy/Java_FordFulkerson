package ConnectedComponent.FordFulkerson;

import java.util.ArrayList;
import java.util.List;

public class FlowNetwork {
	private int numOfVertices;
	private int numOfEdges;
	private List<List<Edge>> adjaciesList;

	public FlowNetwork(int numOfVertices) {
		this.numOfVertices = numOfVertices;
		this.numOfEdges = 0;
		this.adjaciesList = new ArrayList<>();

		for (int i = 0; i < numOfVertices; i++) {
			List<Edge> edgeList = new ArrayList<>();
			adjaciesList.add(edgeList);
		}
	}

	public int getNumOfVertices() {
		return numOfVertices;
	}

	public void setNumOfVertices(int numOfVertices) {
		this.numOfVertices = numOfVertices;
	}

	public int getNumOfEdges() {
		return numOfEdges;
	}

	public void setNumOfEdges(int numOfEdges) {
		this.numOfEdges = numOfEdges;
	}

	public List<Edge> getAdjaciesList(Vertex vertex) {
		return adjaciesList.get(vertex.getId());
	}

	public void setAdjaciesList(List<List<Edge>> adjaciesList) {
		this.adjaciesList = adjaciesList;
	}

	public void addEdge(Edge edge) {
		Vertex startVertex = edge.getStartVertex();
		Vertex targetVertex = edge.getTargetVertex();
		adjaciesList.get(startVertex.getId()).add(edge);
		adjaciesList.get(targetVertex.getId()).add(edge);
		this.numOfEdges++;
	}

}
