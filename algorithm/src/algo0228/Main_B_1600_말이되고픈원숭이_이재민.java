package algo0228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 벽부수고 이동하기 처럼 3차원 배열 사용
 * 배열 선언 시 K+1로 두고 말로 이동한 횟수 k가 K보다 작으면 말로 이동하는 것도 넣어주고 방문배열 체크
 * 59400KB | 432ms
 */
public class Main_B_1600_말이되고픈원숭이_이재민 {
	static int K;
	static int N, M;
	static int[][] map;
	static boolean[][][] visited;
	
	static int[] mdx = { -1, 1, 0, 0 };
	static int[] mdy = { 0, 0, -1, 1 };

	static int[] hdx = { -2, -1, 1, 2, 2, 1, -1, 2 };
	static int[] hdy = { 1, 2, 2, 1, -1, -2, -2, -1 };

	static class Loc {
		int r, c, d, k;

		public Loc(int r, int c, int d, int k) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
			this.k = k;
		}
	}

	static boolean rangeCheck(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

	static int bfs() {
		Queue<Loc> q = new ArrayDeque<>();
		q.add(new Loc(0, 0, 0, 0));
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			
			Loc loc = q.poll();
			if (loc.r == N - 1 && loc.c == M - 1) {
				return loc.d;
			}
			
			int size = loc.k < K ? 8 : 4;

			for (int i = 0; i < size; i++) {
				if (i < 4) {
					int nr = loc.r + mdx[i];
					int nc = loc.c + mdy[i];
					
					if (rangeCheck(nr, nc) && !visited[nr][nc][loc.k] && map[nr][nc] == 0) {
						q.add(new Loc(nr, nc, loc.d + 1, loc.k));
						visited[nr][nc][loc.k] = true;
					}
				}
				
				if (size == 8) {
					int nr = loc.r + hdx[i];
					int nc = loc.c + hdy[i];
					if (!rangeCheck(nr, nc))
						continue;
					if (visited[nr][nc][loc.k+1])
						continue;
					if (map[nr][nc] == 1)
						continue;
					q.add(new Loc(nr, nc, loc.d + 1, loc.k + 1));
					visited[nr][nc][loc.k+1] = true;
				}

			}

		}

		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		K = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M][K+1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(bfs());

	}

}
