package algo0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 순열을 뽑고 각 base에 대한 정보를 저장하여
 * 칠때마다 갱신
 * 14352KB | 432ms
 */
public class Main_B_야구_17281_이재민 {
	static int N;
	static int[][] player;
	static int[] visited, picked;
	static int res;
	static int[] base;
	
	
	static void play() {
		int curHitter = 1;
		int score = 0;
		for(int i=0; i<N; i++) {
			int out = 0;
			Arrays.fill(base, 0);
			while(out < 3) {
				int hitloc = picked[curHitter];
				int hit = player[i][hitloc];
				if(hit == 0) out++;
				
				else {
					for(int j=3; j>0; j--) {
						if(base[j] == 1) {
							if(j + hit > 3) {
								base[j] = 0;
								score++;
							}
							else {
								base[j+hit] = 1;
								base[j] = 0;
							}
						}
					}
					if(hit == 4) score++;
					else {
						base[hit] = 1;
//						score++;
					}
				}
				curHitter++;
				if(curHitter > 9) curHitter = 1;
		
			}
		}
		res = Math.max(res, score);
	}
	
	static void permu(int cnt, int flag) {
		if(cnt==10) {
			play();
			return ;
		}
		
		for(int i=2; i<=9; i++) {
			if((flag & (1 << i)) != 0) continue;
			
			picked[cnt] = i;
			permu(cnt==3 ? cnt+2 : cnt+1, flag | (1<<i));
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		player = new int[N][10];
		picked = new int[10];
		picked[4] = 1;
		base = new int[4];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=9; j++) {
				player[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		permu(1, 0);
		
		System.out.println(res);
		
	}

}
