package algo0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 2차원 list에 넣고 현재 정점에서 방문 가능한 정점을 찾아
 * dfs와 bfs 수행
 * 18016KB | 200ms
 */

public class Main_B_1260_DFS와BFS_이재민_인접리스트 {
	
	static int N, M, V;
	static List<Integer> list[];
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	static void dfs(int x) {
		sb.append(x + " ");
		visited[x] = true;
		
		for(int nx : list[x]) {
			if(!visited[nx]) dfs(nx);
		}
	}
	
	static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(V);
		visited[V] = true;
		while(!q.isEmpty()) {
			int x = q.poll();
			sb.append(x + " ");
			
			for(int nx : list[x]) {
				if(!visited[nx]) {
					q.add(nx);
					visited[nx] = true;
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
		
		list = new ArrayList[N+1];
		
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[x].add(y);
			list[y].add(x);
		}
		// 작은 것 부터 출력하기 위해 정렬
		for(int i=1; i<=N; i++) {
			list[i].sort(Comparator.naturalOrder());
		}
		visited = new boolean[N+1];
		dfs(V);
		sb.append('\n');
		visited = new boolean[N+1];
		bfs();
		
		System.out.println(sb.toString());
	}

}