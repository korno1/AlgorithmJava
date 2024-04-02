package algo0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 연산 1, 2는 그대로 수행
 * 연산 3, 4 는 수행 전 n과 m값을 바꿈
 * 연산 5, 6 은 System.arraycopy함수를 사용해 복사
 * 57684KB | 304ms
 */

public class Main_B_16935_배열돌리기3_이재민 {

	static int[][] map;
	static int n, m, r;
	static int[][] d = { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 1, 0 } };
	static int[][] d5 = { { 1, 0 }, { 0, 0 }, { 0, 1 }, { 1, 1 } };
	static int[][] d6 = { { 0, 1 }, { 1, 1 }, { 1, 0 }, { 0, 0 } };

	static void swap() {
		int temp = n;
		n = m;
		m = temp;
	}

	// 상하반전
	static int[][] ud() {
		int[][] copy = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy[i][j] = map[n - 1 - i][j];
			}
		}

		return copy;
	}

	// 좌우반전
	static int[][] lr() {
		int[][] copy = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy[i][j] = map[i][m - 1 - j];
			}
		}

		return copy;
	}

	// 오른쪽 90도
	static int[][] rotateR() {
		int[][] copy = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy[i][j] = map[m - j - 1][i];
			}
		}

		return copy;
	}

	// 왼쪽 90도
	static int[][] rotateL() {
		int[][] copy = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy[i][j] = map[j][n - i - 1];
			}
		}

		return copy;
	}

	// 연산5
	static int[][] forward() {
		int[][] copy = new int[n][m];

		for (int i = 0; i < 4; i++) {
			// 복사할 배열의 시작 idx
			int r = d5[i][0] * (n / 2);
			int c = d5[i][1] * (m / 2);			
			
			// 복사 받을 배열의 시작 idx
			int x = d[i][0] * (n/2);
			int y = d[i][1] * (m/2);
			
			for(int j=x; j<n/2+x; j++)
				System.arraycopy(map[r++], c, copy[j], y, m/2);
				//(복사할 배열, 어디서부터 열, 복사받을 배열, 어디 열부터 복사, /)
		}

		return copy;
	}

	// 연산6
	static int[][] reverse(){
		int[][] copy = new int[n][m];
		for (int i = 0; i < 4; i++) {
			int r = d6[i][0] * (n / 2);
			int c = d6[i][1] * (m / 2);			
			
			int x = d[i][0] * (n/2);
			int y = d[i][1] * (m/2);
			
			for(int j=x; j<n/2+x; j++)
				System.arraycopy(map[r++], c, copy[j], y, m/2);
				//(복사할 배열, 어디서부터 열, 복사받을 배열, 어디 열부터 복사, 얼만큼 복사)
		}

		return copy;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < r; i++) {
			int input = Integer.parseInt(st.nextToken());
			switch (input) {
			case 1:
				map = ud();
				break;
			case 2:
				map = lr();
				break;
			case 3:
				swap();
				map = rotateR();
				break;
			case 4:
				swap();
				map = rotateL();
				break;
			case 5:
				map = forward();
				break;
			case 6:
				map = reverse();
				break;
			}

		}
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
