package algo0227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/*
 * list로 집의 위치를 담고 모든 위치에서 탐색
 * K가 맵의 최대치까지 탐색을 해야함
 * 25620KB | 341ms
 */

public class Solution_2117_홈방범서비스_이재민 {
	static int N, M;
	static int map[][];
	static List<Loc> house;
	
	static int res;
	
	static class Loc{
		int x, y;

		public Loc(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			res = 0;
			map = new int[N][N];
			house = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) house.add(new Loc(i, j));
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int k = 1;
					while(true) {
						int cost = (k*k) + (k-1)*(k-1);
						int sum = 0;
						int homeCnt = 0;
						
						for(int h = 0; h<house.size(); h++) {
							int dist = Math.abs(i - house.get(h).x) + Math.abs(j - house.get(h).y);
							if(dist <= k-1) {
								sum += M;
								homeCnt++;
							}
						}
						if(sum - cost >= 0) {
							res = Math.max(res, homeCnt);
						}
						if(k==N+1) break;
						k++;
					}
				}
			}
			
			sb.append("#" + tc + " " + res).append('\n');
		}
		System.out.println(sb);
		
	}
}
