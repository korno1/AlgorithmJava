package algo0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * dfs 백트래킹을 이용하여 탐색
 * 알파벳을 사용중인지 비트마스킹을 사용
 * 12696KB | 756ms
 */
public class Main_B_1987_알파벳_이재민 {
	static int R, C, res;
	static char[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static boolean rangeCheck(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}

	static void dfs(int x, int y, int cnt, int isUsed) {
		if(cnt==26) {
			System.out.println(26);
			System.exit(0);
		}
		
		res = Math.max(res, cnt);
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (rangeCheck(nx, ny)) {
				if ((isUsed & (1 << (map[nx][ny] - 'A'))) != 0) 
					continue;
				
				
				dfs(nx, ny, cnt + 1, isUsed | (1 << (map[nx][ny] - 'A')));
				
			}
		}
//		alpha[map[x][y] - 'A'] = false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}


		dfs(0, 0, 1, 1 << (map[0][0] - 'A'));

		System.out.println(res);
	}
}
