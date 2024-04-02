package algo0202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * knapsack (dp)를 이용한 문제풀이
 * 32528KB | 166ms
 */

public class Solution_5215_햄버거다이어트_이재민 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 재료 개수
			int l = Integer.parseInt(st.nextToken()); // 칼로리 제한
		
			int[] s = new int[n+1]; // 점수 저장
			int[] c = new int[n+1]; // 칼로리 저장
			int[][] dp = new int[n+1][l+1];
			
			for(int i=1; i<=n; i++) {
				st = new StringTokenizer(br.readLine());
				s[i] = Integer.parseInt(st.nextToken()); // 점수
				c[i] = Integer.parseInt(st.nextToken()); // 칼로리
				
			}
			
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=l; j++) {
					if(c[i] <= j) { // 현재 재료의 칼로리가 j보다 작으면
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-c[i]] + s[i]);
						// 이전 i배열의 칼로리와 (현재 칼로리 + 이전 배열의 j-칼로리의idx)를 비교
					}
					else dp[i][j] = dp[i-1][j];
				}
			}
			
			System.out.println("#" + tc + " " + dp[n][l]);
		}
	}

}
