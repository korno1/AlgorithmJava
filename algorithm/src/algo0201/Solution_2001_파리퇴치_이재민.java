package algo0201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 구간합 구하기 5처럼 누적합 사용
 * 17424KB | 120ms
 */

public class Solution_2001_파리퇴치_이재민 {
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		
		
		for(int tc=1; tc<=t; tc++) {
			int res = 0;
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[n+1][n+1];
			
			for(int i=1; i<=n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=n; j++) {
					map[i][j] = map[i-1][j] + map[i][j-1] - map[i-1][j-1] + Integer.parseInt(st.nextToken());
				}
			}
			
			
			for(int i=m; i<=n; i++) {
				for(int j=m; j<=n; j++) {
					res = Math.max(res, map[i][j] - map[i-m][j] - map[i][j-m] + map[i-m][j-m]);
				}
			}
			
			
			System.out.println("#" + tc + " " + res);
			
			
		}
	}

}
