package miniMaratona4;

import java.util.ArrayList;

public class Path {

	public static void main(String[] args) {
		//grafo nao direcional
		System.out.println(validPath(6, new int[][] { { 0, 1 }, { 2, 4 }, { 4, 5 }, { 1, 5 }, { 0, 3 } }, 0, 2));
		System.out.println(validPath(3, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 0 } }, 0, 2));
		System.out.println(validPath(6, new int[][] { { 0, 1 }, { 0, 2 }, { 3, 5 }, { 5, 4 }, { 4, 3 } }, 0, 5));
	}

	public static boolean validPath(int n, int[][] edges, int source, int destination) {
		ArrayList<Integer>[] graph = new ArrayList[n];

		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < edges.length; i++) { //add adj nos dois vertices
			graph[edges[i][0]].add(edges[i][1]);
			graph[edges[i][1]].add(edges[i][0]);
		}
		boolean[] visited = new boolean[n];
		return dfs(visited, source, destination, false, graph);
	}

	private static boolean dfs(boolean[] visited, int u, int destination, boolean res, ArrayList<Integer>[] graph) {
		visited[u] = true;
		if (!res) {
			if (graph[u].contains(destination)) {
				res = true;
			} else {
				for (int i = 0; i < graph[u].size(); i++) {
					if (!visited[graph[u].get(i)]) {
						res = dfs(visited, graph[u].get(i), destination, res, graph);
					}
				}
			}
		}
		return res;
	}
}
