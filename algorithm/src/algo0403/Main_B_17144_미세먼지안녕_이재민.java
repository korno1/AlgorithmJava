package algo0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 미세먼지가 동시에 확산되기 때문에 포문을 돌리면서 바로 확산시키면 안됨
 * 미세먼지가 확산되는 양을 미리 다른 배열에 저장해놓고
 * 후에 퍼질때 돌려주기
 *  13196KB | 228ms
 */

public class Main_B_17144_미세먼지안녕_이재민 {
	static int R, C, T, ax, ay, res;
	static int[][] map;
	static int[][] spreadMap;
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
					for(int k=0; k<4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if(!rangeCheck(nx, ny)) continue;
						if(map[nx][ny] == -1) continue;
						spreadMap[nx][ny] += map[i][j] / 5;
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
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] >= 0) {
					map[i][j] += spreadMap[i][j];
				}
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
		// 아래쪽
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
		spreadMap = new int[R][C];
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
			for(int i=0; i<R; i++) {
				Arrays.fill(spreadMap[i], 0);
			}
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
		// 공기청정기 값 제외
		System.out.println(res+2);
	}

}
