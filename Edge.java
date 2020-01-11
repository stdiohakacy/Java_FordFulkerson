package ConnectedComponent.FordFulkerson;

public class Edge {
	private Vertex startVertex;
	private Vertex targetVertex;
	private final double capacity;
	private double flow;

	public Edge(Vertex startVertex, Vertex targetVertex, double capacity) {
		this.startVertex = startVertex;
		this.targetVertex = targetVertex;
		this.capacity = capacity;
		this.flow = 0.0;
	}

	public Vertex getStartVertex() {
		return startVertex;
	}

	public void setStartVertex(Vertex startVertex) {
		this.startVertex = startVertex;
	}

	public Vertex getTargetVertex() {
		return targetVertex;
	}

	public void setTargetVertex(Vertex targetVertex) {
		this.targetVertex = targetVertex;
	}

	public double getFlow() {
		return flow;
	}

	public void setFlow(double flow) {
		this.flow = flow;
	}

	public double getCapacity() {
		return capacity;
	}

	public Edge(Edge edge) {
		this.startVertex = edge.getStartVertex();
		this.startVertex = edge.getTargetVertex();
		this.capacity = edge.getCapacity();
		this.flow = edge.getFlow();
	}

	public Vertex getOther(Vertex vertex) {
		if (vertex == this.startVertex) {
			return this.targetVertex;
		} else {
			return this.startVertex;
		}
	}

	public double getResidualCapacity(Vertex vertex) {
		if (vertex == this.startVertex) {
			return this.flow;
		} else {
			return this.capacity - this.flow;
		}
	}

	public void addResidualFlowTo(Vertex vertex, double delteFLow) {
		if (vertex == this.startVertex) {
			this.flow -= delteFLow;
		} else {
			this.flow += delteFLow;
		}
	}

	@Override
	public String toString() {
		return this.startVertex + " - " + this.startVertex + " " + this.flow + "/" + this.capacity;
	}
}
