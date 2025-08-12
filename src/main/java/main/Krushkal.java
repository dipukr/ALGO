package main;

public class Krushkal {

	private Edge[] edges;
	private UnionFind uf;

	public Krushkal(Edge[] edges, int n) {
		this.edges = edges;
		this.uf = new UnionFind(n);
		java.util.Arrays.sort(edges);
	}

	public int solve() {
		int sum = 0;
		for (Edge edge: edges) {
			if (uf.connected(edge.start, edge.end))
				continue;
			uf.union(edge.start, edge.end);
			sum += edge.weight;
		}
		return sum;
	}
}