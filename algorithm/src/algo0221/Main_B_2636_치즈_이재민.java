package algo0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 미리 치즈의 개수를 세고 visited 배열을 통해 방문체크를 해주는데
 * 방문하지 않았을때 치즈면 녹이고 방문처리
 * 아니면 dfs를 돌아줌
 * 12644KB | 96ms
 */

public class Main_B_2636_치즈_이재민 {

	static int N, M, cheeze;
	static int[][] map;
	static int res;
	static boolean[][] visited;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static boolean rangeCheck(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}


	static void dfs(int x, int y) {
		visited[x][y] = true;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(!rangeCheck(nx, ny)) continue;
			if(!visited[nx][ny]) {
				if(map[nx][ny] == 1) {
					map[nx][ny] = 0;
					cheeze--;
					visited[nx][ny] = true;
				}
				else {
					dfs(nx, ny);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int T = 0;
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					cheeze++;
			}
		}
		res = cheeze;
		while (true) {
			T++;
			visited = new boolean[N][M];

			dfs(0, 0);
			if (cheeze == 0)
				break;
			res = cheeze;
		}
		sb.append(T).append('\n');
		sb.append(res);
		System.out.println(sb);
	}

}
