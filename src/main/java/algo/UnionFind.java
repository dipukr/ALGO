package algo;

public class UnionFind {

	private int[] parent;

	public UnionFind(int n) {
		parent = new int[n];
		for (int i = 0; i < n; i++)
			parent[i] = i;
	}

	public int root(int v) {
		if (v == parent[v])
			return v;
		return parent[v] = root(parent[v]);
	}

	public boolean find(int u, int v) {
		return root(u) == root(v);
	}
	
	public boolean connected(int u, int v) {
		return find(u, v);
	}

	public void union(int u, int v) {
		int r1 = root(u);
		int r2 = root(v);
		if (r1 != r2) parent[r2] = r1;
	}
}