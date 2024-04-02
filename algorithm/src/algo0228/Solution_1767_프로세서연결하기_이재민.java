package algo0228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/*
 * 경계선에서 연결이 되는 코어를 제외하고 나머지 코어들로 수행
 * 백트래킹을 이용하고, 연결이 가능한지 체크 후 link 수행
 * 22904KB | 183ms
 */
public class Solution_1767_프로세서연결하기_이재민 {

	static int N, coreCount, coreRes;
	static int wireCount, wireRes;
	static int[][] map;
	static List<Loc> core;
	static int coreSize;
	// 상 우 하 좌
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int idx;

	static class Loc {
		int x, y, cnt;
		boolean flag = false;

		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static boolean rangeCheck(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

	static void link(int x, int y, int dir, boolean flag) {
		int nx = x;
		int ny = y;

		while (true) {
			nx += dx[dir];
			ny += dy[dir];
			if(!rangeCheck(nx, ny)) return ;
			map[nx][ny] = flag ? -1 : 0;
			wireCount += flag ? 1 : -1;
		}
	}

	static boolean linkCheck(int x, int y, int dir) {
		int nx = x;
		int ny = y;

		while (true) {
			nx += dx[dir];
			ny += dy[dir];

			if (!rangeCheck(nx, ny))
				return true;
			if (map[nx][ny] != 0)
				return false;
		}

	}

	static void dfs(int cnt) {
		if (cnt == coreSize) {
			if (coreCount == coreRes) {
				if (wireRes > wireCount) {
					wireRes = wireCount;
				}

			} else if (coreCount > coreRes) {
				coreRes = coreCount;
				wireRes = wireCount;
			}
			return;
		}

		int x = core.get(cnt).x;
		int y = core.get(cnt).y;
		
		// 선택하지 않는게 결과값일 수 있음
		dfs(cnt+1); 
		for (int i = 0; i < 4; i++) {
			
			if (!linkCheck(x, y, i)) {
				continue;
			}

			link(x, y, i, true);
			coreCount++;

			dfs(cnt + 1);

			link(x, y, i, false);
			coreCount--;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			wireRes = 0;
			wireCount = 0;
			coreRes = 0;
			coreCount = 0;
			core = new ArrayList<>();
			coreSize = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						if (i == 0 || i == N - 1 || j == 0 || j == N - 1)
							coreCount++;
						else {
							core.add(new Loc(i, j));
							coreSize++;
						}
					}
				}
			}
			coreRes = coreCount;
			dfs(0);
			sb.append("#" + tc + " " + wireRes).append('\n');

		}
		System.out.println(sb.toString());
	}
}