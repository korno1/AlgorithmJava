package algo0216;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2차원 행렬에서 현재 정점에서 방문 가능한 지점을 찾아서
 * dfs와 bfs 수행
 * 18264KB | 224ms
 */

public class Main_B_1260_DFS와BFS_이재민_인접행렬 {
	
	static int N, M, V;
	static boolean[][] matrix;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	static void dfs(int x) {
		sb.append(x + " ");
		visited[x] = true;
		
		for(int i=0; i<matrix[x].length; i++) {
			if(matrix[x][i] && !visited[i]) {
				dfs(i);
			}
		}
	}
	
	static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(V);
		visited[V] = true;
		while(!q.isEmpty()) {
			int x = q.poll();
			sb.append(x + " ");
			
			for(int i=0; i<matrix[x].length; i++) {
				if(matrix[x][i] && !visited[i]) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		matrix = new boolean[N+1][N+1];
		
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			matrix[x][y] = true;
			matrix[y][x] = true;
		}
		
		visited = new boolean[N+1];
		dfs(V);
		sb.append('\n');
		visited = new boolean[N+1];
		bfs();
		
		System.out.println(sb.toString());
	}

}
