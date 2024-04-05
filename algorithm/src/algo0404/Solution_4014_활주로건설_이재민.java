package algo0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 높이차가 다르면 경사로를 왼쪽에 둬야하는지 오른쪽에 둬야하는지
 * 판단하고 조건에 맞게 경사로 두기
 * 각 행과 열을 1차원 배열로 복사해서 사용
 * 경사로를 둬야하는 ramp라는 boolean 배열을 이용하여 경사로를 둔 곳인지 판단
 * 30096KB | 128ms
 */
public class Solution_4014_활주로건설_이재민 {
	static int N, X, res;
	static int[][] map;
	static int copy[];
	static boolean[] ramp;

	static void airStrip() {
		// 가로
		for (int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, copy, 0, N);
			Arrays.fill(ramp, false);
			boolean resCheck = true;

			for (int j = 0; j < N - 1; j++) {
				if (Math.abs(copy[j] - copy[j + 1]) > 1) {
					resCheck = false;
					break;
				}

				if (Math.abs(copy[j] - copy[j + 1]) == 1) {
					// false면 왼쪽이 더 작은 것, true면 오른쪽이 더 작은 것
					boolean dir = false;
					if (copy[j] - copy[j + 1] > 0)
						dir = true;

					if (!check(dir, j, i)) {
						resCheck = false;
						break;
					}
				}
			}
			if (resCheck) {
				res++;
			}
		}

		// 세로
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy[j] = map[j][i];
			}
			Arrays.fill(ramp, false);
			boolean resCheck = true;

			for (int j = 0; j < N - 1; j++) {
				if (Math.abs(copy[j] - copy[j + 1]) > 1) {
					resCheck = false;
					break;
				}

				if (Math.abs(copy[j] - copy[j + 1]) == 1) {
					// false면 왼쪽이 더 작은 것, true면 오른쪽이 더 작은 것
					boolean dir = false;
					if (copy[j] - copy[j + 1] > 0)
						dir = true;

					if (!check(dir, j, i)) {
						resCheck = false;
						break;
					}
				}
			}
			if (resCheck) {
				res++;
			}
		}
	}

	static boolean check(boolean dir, int d, int time) {
		// 오른쪽에 경사로를 둬야함
		if (dir) {
			int x = d + 1;
			int cnt = 1;
			int height = copy[d];
			while (true) {
				if (ramp[x])
					return false;
				if (height - copy[x] != 1)
					return false;

				ramp[x] = true;
				if (cnt == X)
					return true;

				cnt++;
				x++;

				if (x >= N)
					return false;

			}
		}

		else {
			int x = d;
			int cnt = 1;
			int height = copy[d + 1];
			while (true) {
				if (ramp[x])
					return false;
				ramp[x] = true;

				if (height - copy[x] != 1)
					return false;
				if (cnt == X) {
					return true;
				}
				cnt++;
				x--;

				if (x < 0)
					return false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			res = 0;
			map = new int[N][N];
			copy = new int[N];
			ramp = new boolean[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			airStrip();
			sb.append(res).append('\n');
		}
		System.out.println(sb);

	}

}