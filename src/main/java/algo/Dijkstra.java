package algo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {

	private PriorityQueue<Integer> pq = new PriorityQueue<>();
	private Map<Integer, List<Integer>> dg;
	private double dist[];

	public Dijkstra(Map<Integer, List<Integer>> dg, int start) {
		this.dg = dg;
		dist = new double[dg.size()];
		Arrays.fill(dist, Double.POSITIVE_INFINITY);
		search(start);
	}

	public void search(int start) {
		pq.offer(start);
		dist[start] = 0;
		while (!pq.isEmpty()) {
			int u = pq.poll();
			for (int v: dg.get(u)) {
				//if (dist[v] > dist[u] + dg.cost(u, v)) {
				//	dist[v] = dist[u] + dg.cost(u, v);
				//	pq.offer(v);
				//}
			}
		}
	}

	public boolean hasPathTo(int v) {
		return dist[v] != Double.POSITIVE_INFINITY;
	}

	public double distanceTo(int v) {
		return dist[v];
	}
}