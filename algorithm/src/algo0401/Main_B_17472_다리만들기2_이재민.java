package algo0401;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 각 섬을 노드라고 생각하고 섬을 잇는 길이를 가중치라고 생각함
 * 섬을 잇는 모든 간선을 저장하고 크루스칼 알고리즘으로 최소값 구하기
 * 11708KB | 80ms
 */
public class Main_B_17472_다리만들기2_이재민 {

	static int N, M, islandCnt, res;
	static int[][] map;
	static boolean[][] visited, island;
	static List<Node> list;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[] p;
	
	static class Node implements Comparable<Node>{
		int from, to, weight;

		public Node(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}

		@Override
		public String toString() {
			return "Node [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
		
		
		
	}

	static boolean rangeCheck(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

	static void numbering(int x, int y, int cnt) {
		visited[x][y] = true;
		map[x][y] = cnt;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(!rangeCheck(nx, ny)) continue;
			if(visited[nx][ny]) continue;
			
			if(map[nx][ny] == 1)
				numbering(nx, ny, cnt);
		}
		
	}
	
	static void putBridge(int x, int y) {
		for(int i=0; i<4; i++) {
			int cnt = 1;
			int islandNum = 0;
			boolean c = true;
			while(true) {
				int nx = x + dx[i] * cnt;
				int ny = y + dy[i] * cnt;
				if(!rangeCheck(nx, ny)) {
					cnt = 1;
					c = false;
					break;
				}
				if(map[nx][ny] == map[x][y]) {
					c = false;
					break;
				}
				
				if(map[nx][ny] != 0) {
					islandNum = map[nx][ny];
					break;
				}
				cnt++;
			}
			if(!c || cnt <= 2) continue;
			cnt--;
			if(map[x][y] < islandNum) {
				list.add(new Node(map[x][y], islandNum, cnt));
			}
			else {
				list.add(new Node(islandNum, map[x][y], cnt));
			}
			
		}
	}
	
	static void makeEdge() {
		list = new ArrayList<>();
		island = new boolean[islandCnt+1][islandCnt+1];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] != 0) {
					putBridge(i, j);
				}
			}
		}
	}
	
	static void makeSet() {
		for(int i=1; i<=islandCnt; i++) {
			p[i] = i;
		}
	}

	static int findSet(int x) {
		if(p[x] == x) return x;
		return p[x] = findSet(p[x]);
	}
	
	static boolean union(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		
		if(x==y) return false;
		p[x] = y;
		
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 1;
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					numbering(i, j, cnt++);
					islandCnt++;
				}
			}
		}
		
		
		makeEdge();
		
		p = new int[islandCnt+1];
		makeSet();
		
		
		Collections.sort(list);
		cnt = 0;
		for(Node node : list) {
			int from = node.from;
			int to = node.to;
			int weight = node.weight;
			if(!union(from, to)) continue;
			res += weight;
			if(++cnt == islandCnt-1) break;
		}
		
		// 고수가 알려줌
		if(cnt != islandCnt-1) res = -1;
		System.out.println(res);
	}

}
