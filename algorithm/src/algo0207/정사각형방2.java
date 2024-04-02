package algo0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 정사각형방2 {

	static int[][] d = { { 1, 0 }, { 0, 1 } };

	static boolean rangeCheck(int x, int y, int n) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			int start = 0;
			int res = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					Queue<int[]> q = new ArrayDeque<int[]>();
					boolean[][] check = new boolean[n][n];
					q.add(new int[] { i, j });
					int ucnt = 1;
					int dcnt = 1;
					int xx = 0;
					int yy = 0;
					while (!q.isEmpty()) {
						int x = q.peek()[0];
						int y = q.poll()[1];

						for (int idx = 0; idx < 2; idx++) {
							int nx = x + d[idx][0];
							int ny = y + d[idx][1];

							if (rangeCheck(nx, ny, n) && (!check[nx][ny])) {
								if(map[x][y] + 1 == map[nx][ny]) {
									check[nx][ny] = true;
									q.add(new int[] { nx, ny });
									ucnt++;
								}
								else if(map[x][y] - 1 == map[nx][ny]) {
									check[nx][ny] = true;
									q.add(new int[] {nx, ny});
									dcnt++;
									xx = nx;
									yy = ny;
								}
							}
						}
					}

					if(ucnt > dcnt) {
						if(ucnt > res) {
							start = map[i][j];
							res = ucnt;
						}
						else if(ucnt == res) {
							start = Math.min(map[i][j], start);
						}
					}
					else {
						if(dcnt > res) {
							start = map[xx][yy];
							res = dcnt;
						}
						else if(dcnt == res) {
							start = Math.min(map[xx][yy], start);
							
						}
					}
				} // end j

			} // end i

			System.out.println("#" + tc + " " + start + " " + res);

		}

	}

}
