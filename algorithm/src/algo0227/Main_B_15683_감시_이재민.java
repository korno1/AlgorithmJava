package algo0227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 미리 사각지대의 개수를 세어놓고 백트래킹으로 cctv 종류별로 map을 갱신해줌
 * 갱신할 때 미리 사각지대의 개수를 조정해서 cnt가 cctv의 개수와 같으면 결과값을 갱신
 * 
 * 방문체크는 cctv가 감시할때는 map이 <= 0이면 작으면 갱신해주지만 사각지대는 map이 0일때 한번만 줄여줌
 * 감시를 해제할때는 map이 < 0일때 map을 하나씩 더해주고 -1일때만 사각지대를 풀어줌
 * 15700KB | 124ms
 */
public class Main_B_15683_감시_이재민 {

	static List<Loc> cctv;
	static int N, M;
	static int[][] map;
	static int res = Integer.MAX_VALUE;
	// 위 오른쪽 아래 왼쪽
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int blindSpot;
	static int rotate[] = { 0, 4, 2, 4, 4, 1 };

	static class Loc {
		int x, y, num;

		public Loc(int x, int y, int num) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
		}

	}

	static boolean rangeCheck(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

	static void observation(int x, int y, int dir) {

		int nx = x + dx[dir];
		int ny = y + dy[dir];

		if (rangeCheck(nx, ny) && map[nx][ny] != 6) {
			if (map[nx][ny] <= 0) {
				if (map[nx][ny] == 0)
					blindSpot--;
				map[nx][ny]--;
			}
			observation(nx, ny, dir);
		}
	}

	static void clear(int x, int y, int dir) {

		int nx = x + dx[dir];
		int ny = y + dy[dir];

		if (rangeCheck(nx, ny) && map[nx][ny] != 6) {
			if (map[nx][ny] < 0) {
				if (map[nx][ny] == -1)
					blindSpot++;
				map[nx][ny]++;

			}

			clear(nx, ny, dir);

		}
	}

	static void dfs(int cnt) {
		if (cnt == cctv.size()) {
			res = Math.min(blindSpot, res);
			return;
		}

		int x = cctv.get(cnt).x;
		int y = cctv.get(cnt).y;
		int cNum = cctv.get(cnt).num;

		for (int i = 0; i < rotate[cNum]; i++) {

			for(int j=0; j<cNum-1; j++) {
				observation(x, y, (i + j)%4);
			}
			if(cNum == 1) observation(x, y, i);
			else if(cNum==2) observation(x, y, i+2);

			dfs(cnt + 1);

			for(int j=0; j<cNum-1; j++) {
				clear(x, y, (i + j)%4);
			}
			if(cNum == 1) clear(x, y, i);
			else if(cNum==2) clear(x, y, i+2);

		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		cctv = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					cctv.add(new Loc(i, j, map[i][j]));
				}
				if (map[i][j] == 0)
					blindSpot++;
			}
		}
		dfs(0);
		System.out.println(res);
	}

}
