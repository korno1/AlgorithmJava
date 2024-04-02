package algo0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * dfs 백트래킹을 이용하여 탐색
 * 알파벳을 사용중인지 알 수 있는 boolean 배열을 하나 만들고 방문체크도 동시에 함
 * 12444KB | 836ms
 */
public class Main_B_1987_알파벳_이재민2 {
	static int R, C, res;
	static char[][] map;
	static boolean[] alpha;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static boolean rangeCheck(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}

	static void dfs(int x, int y, int cnt) {
		if(cnt==26) {
			System.out.println(26);
			System.exit(0);
		}
		
		res = Math.max(res, cnt);
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (rangeCheck(nx, ny)) {
				if (!alpha[map[nx][ny] - 'A']) {
					alpha[map[nx][ny] - 'A'] = true;
					dfs(nx, ny, cnt + 1);
				}
				
			}
		}
		alpha[map[x][y] - 'A'] = false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		alpha = new boolean[26];
		
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		alpha[map[0][0] - 'A'] = true;

		dfs(0, 0, 1);

		System.out.println(res);
	}
}
