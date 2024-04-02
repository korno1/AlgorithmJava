package algo0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기 {
	static int N, M;

	static int map[][];
	static int res = Integer.MAX_VALUE;
	static boolean[][][] visited;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	static class Location {
		int x, y, dist;
		int flag;

		public Location(int x, int y, int dist, int flag) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.flag = flag;
		}

	}

	static boolean rangeCheck(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

	static int bfs() {
		Queue<Location> q = new ArrayDeque<>();

		q.add(new Location(0, 0, 1, 0));
		visited[0][0][0] = true;
		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			int dist = q.peek().dist;
			int flag = q.poll().flag;
			if (x == N - 1 && y == M - 1) {
				return dist;
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (!rangeCheck(nx, ny))
					continue;

				if(map[nx][ny] == 1 && flag==0 && !visited[nx][ny][1]) {
					q.add(new Location(nx, ny, dist+1, flag+1));
					visited[nx][ny][1] = true;
				}
				
				if(map[nx][ny] == 0) {
					if(flag == 1 && !visited[nx][ny][1]) {
						q.add(new Location(nx, ny, dist+1, flag));
						visited[nx][ny][1] = true;
					}
					else if(flag == 0 && !visited[nx][ny][0]) {
						q.add(new Location(nx, ny, dist+1, flag));
						visited[nx][ny][0] = true;
					}
				}


			}
		}
		
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		// 0은 벽을 뚫지 않고 지나간 경우
		// 1은 벽을 뚫고 지나간 경우
		visited = new boolean[N][M][2];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		System.out.println(bfs());
		
		

	}

}
