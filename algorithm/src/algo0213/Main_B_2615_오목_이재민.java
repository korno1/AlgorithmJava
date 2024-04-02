package algo0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 오목 판정할 때 바둑알 색이 다르거나 바둑판 범위를 벗어나면 continue를 이용해서 넘어가기
 * 6목 체크는 5개를 다 확인하고 cnt값을 이용해 체크
 * 13056KB | 92ms
 */

public class Main_B_2615_오목_이재민 {
	static int N = 19;
	static int[] dx = { -1, 0, 1, 1 };
	static int[] dy = { 1, 1, 1, 0 };

	static boolean rangeCheck(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int[][] board = new int[N][N];
		int r = 0;
		int c = 0;
		int ans = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] != 0) {
					// 4방향 살펴보기
					A: for (int k = 0; k < 4; k++) {
						int cnt = 1;
						while (cnt <= 4) {
							int x = i + dx[k] * cnt;
							int y = j + dy[k] * cnt;
							// 범위 벗어나거나 바둑알 색이 다르면
							if (!rangeCheck(x, y) || board[i][j] != board[x][y])
								continue A;
							cnt++;
						}
						// 연속되는 지점에 6목 체크
						int x = i + dx[k] * cnt;
						int y = j + dy[k] * cnt;
						if (rangeCheck(x, y) && board[i][j] == board[x][y]) {
							continue;
						}
						// 오른쪽 위로 향하는 오목일 때 6목 체크
						x = i - dx[k];
						y = j - dy[k];
						if (rangeCheck(x, y) && board[i][j] == board[x][y])
							continue;
						System.out.println(board[i][j]);
						System.out.println(i + 1 + " " + (j + 1));
						System.exit(0);
					}
				}
			}
		}

		System.out.println(0);

	}

}
