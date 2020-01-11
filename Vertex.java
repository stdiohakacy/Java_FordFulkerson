package ConnectedComponent.FordFulkerson;

public class Vertex {
	private int id;
	private String name;
	private boolean isVisited;

	public Vertex(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	@Override
	public String toString() {
		return "Vertex [name=" + name + "]";
	}

}
