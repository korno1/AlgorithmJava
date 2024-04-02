package algo0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * bfs 완전 탐색을 이용해서 탐색이 끝날 때마다 결과값 갱신
 * 115668KB | 1101ms
 * 
 */
public class Solution_1861_정사각형방_이재민 {

	static int[][] d = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static boolean rangeCheck(int x, int y, int n) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
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
					int cnt = 1;

					while (!q.isEmpty()) {
						int x = q.peek()[0];
						int y = q.poll()[1];
//						if(i==0 && j==1) System.out.println(x + " " + y);

						for (int idx = 0; idx < 4; idx++) {
							int nx = x + d[idx][0];
							int ny = y + d[idx][1];

							if (rangeCheck(nx, ny, n) && (!check[nx][ny]) && (map[nx][ny] == map[x][y] + 1)) {
								check[nx][ny] = true;
								q.add(new int[] { nx, ny });
								cnt++;
							}
						}
					}

					if (cnt > res) {
						start = map[i][j];
						res = cnt;
					} else if (cnt == res) {
						if (map[i][j] < start) {
							start = map[i][j];
						}
					}
				} // end j

			} // end i
			sb.append("#" + tc + " " + start + " " + res).append('\n');

		}
		System.out.println(sb.toString());
	}

}
