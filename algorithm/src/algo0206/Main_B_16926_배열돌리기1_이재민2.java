package algo0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B_16926_배열돌리기1_이재민2 {

	static int n, m, r;
	// 우 하 좌 상
	public static int d[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static boolean rangeCheck(int x, int y, int i) {
		if (x < i || x >= n - i)
			return false;
		if (y < i || y >= m - i)
			return false;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		long bt = System.currentTimeMillis();
		for (int i = 0; i < Math.min(n, m) / 2; i++) {
			Queue<Integer> q = new ArrayDeque<Integer>();
			int dir = 0;
			int x = i;
			int y = i;

			while (true) {
				if (!rangeCheck(x + d[dir][0], y + d[dir][1], i)) {
					dir++;
				}
				q.add(map[x][y]);

				x += d[dir][0];
				y += d[dir][1];

				if (x == i + 1 && y == i) {
					q.add(map[x][y]);
					break;
				}
			}

			for (int j = 0; j < r; j++) {
				q.add(q.poll());
			}
			dir = 0;
			x = i;
			y = i;
			while (true) {
				if (!rangeCheck(x + d[dir][0], y + d[dir][1], i)) {
					dir++;
				}
				map[x][y] = q.poll();

				x += d[dir][0];
				y += d[dir][1];
				if (x == i + 1 && y == i) {
					map[x][y] = q.poll();
					break;
				}
			}

		} // end for
		long at = System.currentTimeMillis();
		long sdt = (at - bt) ;
		System.out.println(sdt);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

}