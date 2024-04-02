package algo0402;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 현재 파이프 방향으로 갈 수 있는 곳으로 이동해서 목적지에 도달하면 res를 증가
 * 14244KB | 164ms
 */
public class Main_B_17070_파이프옮기기1_이재민_dfs {
	static int N;
	static int[][] map;
	static int res;

	static void dfs(int x, int y, int dir) {
//		System.out.println(x + " " + y + " " + dir);
		if (x == N - 1 && y == N - 1) {
			res++;
			return;
		}

		if (x + 1 < N && y + 1 < N) {
			if (map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0)
				dfs(x + 1, y + 1, 2);
		}
		
		if (dir == 0 || dir == 2) {
			if (x < N && y + 1 < N) {
				if (map[x][y + 1] == 0)
					dfs(x, y + 1, 0);
			}
		}

		if (dir == 1 || dir == 2) {
			if (x + 1 < N && y < N) {
				if (map[x + 1][y] == 0)
					dfs(x + 1, y, 1);
			}
		} 
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 1, 0);
		System.out.println(res);
	}

}
