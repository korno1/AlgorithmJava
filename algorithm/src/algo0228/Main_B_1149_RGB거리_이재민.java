package algo0228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 현재 index에서 0 1 2에서 조건에 따라 현재값과 이전에 저장된 dp값을 더함
 * 12056KB | 88ms
 */
public class Main_B_1149_RGB거리_이재민 {
	static int N;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		
		dp = new int[N+1][3];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<3; j++) {
				if(j==0) dp[i][j] = a + Math.min(dp[i-1][1], dp[i-1][2]);
				else if(j==1) dp[i][j] = b + Math.min(dp[i-1][0], dp[i-1][2]);
				else dp[i][j] = c + Math.min(dp[i-1][0], dp[i-1][1]);
			}
		}
		
		System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
	}

}
