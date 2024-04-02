package algo0229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 순열을 이용해서 모든 경우의 수를 뽑아서 경로 확인
 * 12252KB | 96ms
 */
public class Main_B_10971_외판원순회2_이재민 {
	static int N, res = Integer.MAX_VALUE;
	static int[][] matrix;
	static int[] picked;
	static int idx = 1;

	static void permu(int cnt, int w, int visited) {

		if (w > res) {
			return;
		}

		if (cnt == N) {

			if (matrix[picked[N - 1]][picked[0]] == 0)
				return;

			w += matrix[picked[N - 1]][picked[0]];
			res = Math.min(res, w);
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((visited & (1 << i)) != 0)
				continue;
			picked[cnt] = i;
			if (cnt > 0) {
				if (matrix[picked[cnt - 1]][picked[cnt]] == 0) {
					break;
				}
				permu(cnt + 1, w + matrix[picked[cnt - 1]][picked[cnt]], visited | (1 << i));
			} else
				permu(cnt + 1, w, visited | (1 << i));
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());

		matrix = new int[N][N];
//		visited = new boolean[N];
		picked = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		permu(0, 0, 0);

		System.out.println(res);

	}

}
