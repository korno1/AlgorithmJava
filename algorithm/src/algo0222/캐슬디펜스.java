package algo0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 캐슬디펜스 {

	static int N, M, D;
	static int[][] map;
	static int[][] copyMap;
	static int res, cntAttack;
	
	static Loc[] enemy;
	static Loc[] archer;
	static Loc[] archerCopy;

	static class Loc {
		int r=0, c=0, dist = Integer.MAX_VALUE;

		public Loc() {
		}
		
		public Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	static void attack() {
		for(int i=0; i<3; i++) {
			archerCopy[i] = archer[i];
		}
		int cnt = 0;
		while (cnt < N) {
			int idx = 0;
			for (int i = 0; i < archerCopy.length; i++) {
				int ar = archerCopy[i].r;
				int ac = archerCopy[i].c;
				
				for (int j = ar - D < 0 ? 0 : ar - D; j < ar; j++) {
					
					for(int k=0; k<M; k++) {
						if(copyMap[j][k] == 1) {
							int dist = Math.abs(ar - j) +  Math.abs(ac - k);
							if(dist < enemy[idx].dist) {
								enemy[idx].r = j;
								enemy[idx].c = k;
								enemy[idx].dist = dist;
							}
						}
					}
				}
				idx++;
			}
			
			for(int i=0; i<enemy.length; i++) {
				int r = enemy[i].r;
				int c = enemy[i].c;
				if(copyMap[r][c] != 0) {
					copyMap[r][c] = 0;
					cntAttack++;
				}
			}

			for(int i=0; i<archerCopy.length; i++) {
				archerCopy[i].r -= 1;
				archerCopy[i].c -= 1;
				enemy[i].r = 0;
				enemy[i].c = 0;
				enemy[i].dist = Integer.MAX_VALUE;
			}
			
			cnt++;
		}

	}

	static void combi(int cnt, int idx) {

		if (cnt == 3) {
			for(int i=0; i<3; i++) {
				System.out.print(archer[i].c + " ");
			}
			System.out.println();
			
			for(int i=0; i<3; i++) {
				enemy[i] = new Loc();
				archerCopy[i] = new Loc();
			}
			cntAttack = 0;
			
			for(int i=0; i<N; i++) {
				System.arraycopy(map[i], 0, copyMap[i], 0, M);
			}
			attack();
			
			res = Math.max(res, cntAttack);
			return;
		}

		for (int i = idx; i < M; i++) {
			archer[cnt] = new Loc(N, i);
			combi(cnt + 1, i + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		copyMap = new int[N][M];
		archer = new Loc[3];
		archerCopy = new Loc[3];
		enemy = new Loc[3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		combi(0, 0);
		
		System.out.println(res);
	}

}
