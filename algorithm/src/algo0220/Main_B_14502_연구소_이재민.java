package algo0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * picked는 세운 벽의 위치
 * 뽑은 위치와 방문체크를 전부 1차원으로함
 * 19048KB 208ms
 */
public class Main_B_14502_연구소_이재민 {
	static int N, M, res, wallCnt, zeroCnt;
	static int[][] map;
	static boolean[] picked, visited;
	// 시작점의 위치를 담는 리스트
	static List<Integer> start;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static boolean rangeCheck(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

	static void virus(int x, int y) {
		visited[x * M + y] = true;
		zeroCnt--;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (!rangeCheck(nx, ny))
				continue;
			if (map[nx][ny] == 0 && !picked[nx * M + ny] && !visited[nx * M + ny]) {
				virus(nx, ny);
			}
		}
	}

	static void combi(int cnt, int idx) {
		if (cnt == 3) {
			zeroCnt = N * M - wallCnt - 3;
			visited = new boolean[N * M];
			
			for (int i = 0; i < start.size(); i++) {
				virus(start.get(i) / M, start.get(i) % M);
			}
			
			res = Math.max(res, zeroCnt);
			return;
		}

		for (int i = idx; i < N * M; i++) {
			if (map[i / M][i % M] == 0) {
				picked[i] = true;
				combi(cnt + 1, i + 1);
				picked[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		picked = new boolean[N * M];

		start = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					wallCnt++;
				if (map[i][j] == 2) {
					start.add(i * M + j);
				}
			}
		}
		
		
		combi(0, 0);
		System.out.println(res);
	}

}
