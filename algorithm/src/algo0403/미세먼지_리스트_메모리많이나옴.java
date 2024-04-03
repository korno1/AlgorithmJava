package algo0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 미세먼지_리스트_메모리많이나옴 {
	static int R, C, T, ax, ay, res;
	static int[][] map;
	static List<Loc> dust; // 확산하는 미세먼지 저장 리스트
	static int idx;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	//위쪽 공기청정기
	static int[] updx = {-1, 0, 1, 0};
	static int[] updy = {0, 1, 0, -1};

	//아래쪽 공기청정기
	static int[] downdx = {1, 0, -1, 0};
	static int[] downdy = {0, 1, 0, -1};
	
	static class Loc {
		int r, c;
		int dir[] = new int[4];
		int cnt = 0;

		public Loc(int r, int c) {
			this.r = r;
			this.c = c;
			
		}

	}

	static boolean rangeCheck(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}

	static void spreadList() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				// 미세먼지 확산이 가능할때만 수행
				if(map[i][j] >= 5) {
					// 몇개 방향으로 확산되는지
					int cnt = 0;
					dust.add(new Loc(i, j));
					for(int k=0; k<4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if(!rangeCheck(nx, ny)) continue;
						if(map[nx][ny] == -1) continue;
						dust.get(idx).dir[k] = map[i][j] / 5;
						cnt++;
					}
					
					map[i][j] -= map[i][j] / 5 * cnt;
					
					idx++;
				}
			}
		}
		
		spread();
	}
	
	static void spread() {
		for(int i=0; i<dust.size(); i++) {
			int r = dust.get(i).r;
			int c = dust.get(i).c;
			for(int k=0; k<4; k++) {
				int nr = r + dx[k];
				int nc = c + dy[k];
				if(!rangeCheck(nr, nc)) continue;
				map[nr][nc] += dust.get(i).dir[k];
			}
		}
	}
	
	static void air(boolean direction) {
		int dir = 0;
		// 위쪽
		if(direction) {
			int x = ax-1;
			int y = 0;
	
			while(true) {
				if(!rangeCheck(x + updx[dir], y + updy[dir])) dir++;
				if(dir == 2 && x == ax) dir++;
				
				map[x][y] = map[x + updx[dir]][y + updy[dir]];
				
				x += updx[dir];
				y += updy[dir];
				
				if(x == ax && y == 1) {
					map[x][1] = 0;
					break;
				}
				
			}
		}
		
		else {
			int x = ax+2;
			int y = 0;
	
			while(true) {
				if(!rangeCheck(x + downdx[dir], y + downdy[dir])) dir++;
				if(dir == 2 && x == ax+1) dir++;
				
				map[x][y] = map[x + downdx[dir]][y + downdy[dir]];
				
				x += downdx[dir];
				y += downdy[dir];
				
				if(x == ax+1 && y == 1) {
					map[x][1] = 0;
					break;
				}
				
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		dust = new ArrayList<>();

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1 && ax == 0) {
					ax = i;
				}
			}
		}
		int time = 0;
		while (time < T) {
			// 1. 미세먼지 확산 저장
			idx = 0;
			dust.clear();
			spreadList();
			
			// 2. 위쪽 공기청정기
			air(true);
			
			// 3. 아래쪽 공기청정기
			air(false);
			time++;
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				res += map[i][j];
			}
		}
		System.out.println(res+2);
	}

}
