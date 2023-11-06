package miniMaratona4;

import java.util.ArrayList;

public class Path {

	public static record No(ArrayList<Integer> adj, int V) {
		public void CreateAdj(int v) {
			adj.add(v);
		}
	}

	private static ArrayList<No> graph = new ArrayList<>();

	public static void main(String[] args) {

		System.out.println(validPath(3, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 0 } }, 0, 2));
		System.out.println(validPath(6, new int[][] { { 0, 1 }, { 0, 2 }, { 3, 5 }, { 5, 4 }, { 4, 3 } }, 0, 5));
	}

	public static boolean validPath(int n, int[][] edges, int source, int destination) {
		for (int i = 0; i < n; i++) {
			No no = new No(new ArrayList<Integer>(), i);
			graph.add(no);
		}
		for (int i = 0; i < edges.length; i++) {
			graph.get(edges[i][0]).CreateAdj(edges[i][1]);
			graph.get(edges[i][1]).CreateAdj(edges[i][0]);
		}
		boolean[] visited = new boolean[n];
		return dfs(visited, source, destination);
	}

	private static boolean dfs(boolean[] visited, int u, int destination) {
		visited[u] = true;
		if (!graph.get(u).adj.contains(destination)) {
			for (int i = 0; i < visited.length; i++) {
				if (!visited[i] && graph.get(u).adj.contains(i)) {
					dfs(visited, i, destination);
				}
			}
			return false;
		}
		return true;
	}
}
