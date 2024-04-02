package algo0227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 막대색칠하기_이재민 {
	
	static int dp[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		dp = new int[N+1];
		
		dp[1] = 2;
		if(N > 1)
			dp[2] = 5;
		
		for(int i=3; i<=N; i++) {
			dp[i] = dp[i-1] * 2 + dp[i-2];
		}
		
		System.out.println(dp[N]);
	}

}
