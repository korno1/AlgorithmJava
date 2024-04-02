package algo0402;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 상하좌우를 이동하는데 1이 올라가는 것이 아닌
 * 배열의 각 지점마다 가중치가 있기 때문에
 * 다익스트라 사용
 * 18460KB | 188ms
 */

public class Main_B_4485_녹색옷을입은애가젤다지_이재민 {
	static int N;
	static int[][] map, d;
	static boolean[][] visited;
	static int T = 1;
	static int res;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class Loc implements Comparable<Loc>{
		int x, y, w;

		public Loc(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}

		@Override
		public int compareTo(Loc o) {
			return this.w - o.w;
		}
		
		
	}

	static boolean rangeCheck(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

	static void dijkstra() {
		PriorityQueue<Loc> q = new PriorityQueue<>();
		
		q.add(new Loc(0, 0, map[0][0]));
		d[0][0] = map[0][0];
		while(!q.isEmpty()) {
			Loc l = q.poll();
			
			if(d[l.x][l.y] < l.w) continue;
			for(int i=0; i<4; i++) {
				int nx = l.x + dx[i];
				int ny = l.y + dy[i];
				if(!rangeCheck(nx, ny)) continue;
				
				if(d[nx][ny] > d[l.x][l.y] + map[nx][ny]) {
					d[nx][ny] = d[l.x][l.y] + map[nx][ny];
					
					q.add(new Loc(nx, ny, d[nx][ny]));
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			
			map = new int[N][N];
			d = new int[N][N];
			visited = new boolean[N][N];
			sb.append("Problem " + (T++) + ": ");

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					d[i][j] = Integer.MAX_VALUE;
				}
			}

			dijkstra();

			sb.append(d[N-1][N-1]).append('\n');

		}
		System.out.println(sb);
	}

}
