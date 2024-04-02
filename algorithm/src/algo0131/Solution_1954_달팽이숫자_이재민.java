package algo0131;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * delta와 check함수를 이용해 다음으로 갈 수 있으면 큐에 넣고
 * 못가면 방향 바꾸고 넣어주기
 * 18660KB | 113ms
 */

public class Solution_1954_달팽이숫자_이재민 {

	// 
	static int[][] d = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int[][] map;
	static int n;

	static boolean check(int x, int y) {
		if (x < 0 || x >= n)
			return false;
		if (y < 0 || y >= n)
			return false;
		if (map[x][y] != 0)
			return false;
		return true;
	}

	static void q() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0 });
		map[0][0] = 1;
		int idx = 0;

		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.remove();

			// 다음 배열로 갈 수 있나 확인
			int nx = x + d[idx % 4][0];
			int ny = y + d[idx % 4][1];

			if (!check(nx, ny)) {
				idx++;
			}

			nx = x + d[idx % 4][0];
			ny = y + d[idx % 4][1];
			if (check(nx, ny)) {
				map[nx][ny] = map[x][y] + 1;
				q.add(new int[] { nx, ny });
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			q();
			System.out.println("#" + tc);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}
