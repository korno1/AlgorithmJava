package algo0227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 아파트색칠하기_이재민 {
	static int[] dp;
	
	
	static int recur(int n) {
		
		if(dp[n] != 0) return dp[n];
		
		return dp[n] = recur(n-1) + recur(n-2);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		
		dp[1] = 2;
		dp[2] = 3;
		
		System.out.println(recur(N));
	}

}
