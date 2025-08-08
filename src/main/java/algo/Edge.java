package algo;

public class Edge implements Comparable<Edge> {
	
	public int start;
	public int end;
	public int weight;

	public Edge(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	public int compareTo(Edge that) {
		if (this.weight < that.weight) return -1;
		else if (this.weight > that.weight) return +1;
		else return 0;
	}
}