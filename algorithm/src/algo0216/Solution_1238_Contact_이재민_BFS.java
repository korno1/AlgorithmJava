package algo0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 현재 노드에서 갈 수 있는 곳을 q에 넣고
 * 그 사이즈만큼 for문으로 돌림
 * res는 현재가 마지막 비상 연락망을 돌리는 거면 그대로 최대값이 나오고
 * 만약 더 연락할 수 있는 곳이 있다면 다시 0으로 초기화
 * 20104 KB | 125ms
 */
public class Solution_1238_Contact_이재민_BFS {
	
	static int N, V;
	static List<Integer> list[];
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;
	static int res;
	
	static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(V);
		
		visited[V] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			res = 0;
			for(int i=0; i<size; i++) {
				int x = q.poll();
				System.out.println();
				res = Math.max(res, x);
				
				for(int j=0; j<list[x].size(); j++) {
					int nx = list[x].get(j);
					if(!visited[nx]) {
						visited[nx] = true;
						q.add(nx);
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			N/=2;
			list = new ArrayList[101];
			visited = new boolean[101];
			for(int i=0; i<=100; i++) {
				list[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list[x].add(y);
			}
			
			bfs();
			sb.append("#" + tc + " " + res).append('\n');
		}
		System.out.println(sb.toString());
	}
}
