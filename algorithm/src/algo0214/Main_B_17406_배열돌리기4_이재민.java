package algo0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * class Rotate를 선언 후 배열에 회전 연산 정보 r, c, s를 담기
 * 시계방향 돌리기니까 좌 하 우 상 순서로 배열 당기기
 * 29984KB | 212ms
 */
public class Main_B_17406_배열돌리기4_이재민 {

	static class Rotate {
		int r, c, s;

		public Rotate(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}

	}

	static int n, m, k;
	// 좌 하 우 상
	static int d[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int[][] map;
	
	static Rotate[] rota;
	static Rotate[] picked;

	static boolean[] visited;
	static int res = Integer.MAX_VALUE;

	public static void turn() {
		// 배열 복사
		int[][] arr = new int[n][m];
		for (int j = 0; j < map.length; j++) {
			arr[j] = map[j].clone();
		}
		
		for (int i = 0; i < k; i++) {
			// 배열이 0,0 부터 시작하니 -1
			int r = picked[i].r - 1;
			int c = picked[i].c - 1;
			int s = picked[i].s;
			for (int j = 0; j < s; j++) {
				int sr = r - s + j;
				int sc = c - s + j;
				int dir = 0;
				int temp = arr[sr][sc];
				while (true) {
					// 범위체크
					if (sr + d[dir][0] < r - s + j || sr + d[dir][0] > r + s - j || sc + d[dir][1] < c - s + j
							|| sc + d[dir][1] > c + s - j) {
						dir++;
					}
					
					arr[sr][sc] = arr[sr + d[dir][0]][sc + d[dir][1]];

					sr += d[dir][0];
					sc += d[dir][1];
					if (sr == r - s + j && sc == c - s + 1 + j) {
						arr[sr][sc] = temp;
						break;
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = 0; j < m; j++) {
				sum += arr[i][j];
			}
			res = Math.min(sum, res);
		}
	}

	public static void permu(int cnt) {
		if (cnt == k) {
			turn();
			return;
		}

		for (int i = 0; i < k; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			picked[cnt] = rota[i];
			permu(cnt + 1);
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		rota = new Rotate[k];
		picked = new Rotate[k];
		visited = new boolean[k];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			rota[i] = new Rotate(r, c, s);
		}

		permu(0);

		System.out.println(res);

	}

}