package DP;

import java.util.Scanner;

public class MinCoinTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		
		dp[0] = 0;
		
		for(int i=1; i<=N; i++) {
			int min = dp[i-1] + 1;
			if(i>=4) min = Math.min(dp[i-4]+1, min);
			if(i>=6) min = Math.min(dp[i-6]+1, min);
			
			dp[i] = min;
		}
		
		System.out.println(dp[N]);
	}

}
