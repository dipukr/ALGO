package algo;

public class Edge implements Comparable<Edge> {
	
	public int from, to;
	public int weight;

	public Edge(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge that) {
		if (this.weight < that.weight) return -1;
		else if (this.weight > that.weight) return +1;
		else return 0;
	}
}