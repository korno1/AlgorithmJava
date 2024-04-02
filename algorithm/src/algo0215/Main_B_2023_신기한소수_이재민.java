package algo0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * String으로 뒤에 붙이고 소수인지 아닌지 판단
 * 소수 확인할 때 제곱근까지만 판단하면 되기 때문에 i*i <= n or i <= Math.sqrt(n)으로 판단
 * 만약 소수가 아니면 false return
 * n==1이면 소수 판단 for문이 돌지 않고 소수라고 여기기 때문에 바로 따로 처리
 * 11732KB | 76ms 
 */

public class Main_B_2023_신기한소수_이재민 {
	static int N;
	static StringBuilder sb = new StringBuilder();
	
	static boolean prime(String num) {
		int n = Integer.parseInt(num);
		// for문이 돌지 않고 true를 리턴하므로 따로 처리
		if(n==1) return false;
		
		for(int i=2; i*i<=n; i++) {
			if(n%i==0) return false;
		}
		return true;
	}
	
	static void dfs(int cnt, String num) {
		if(cnt == N) {
			sb.append(num).append('\n');
			return ;
		}
		
		// 처음 부분에서는 2는 짝수 중 유일한 소수이기 때문에 +1을 해서 전부 탐색하고
		// 뒷부분에서는 1부터 홀수만 확인 (짝수는 소수가 아니기 때문)
		for(int i=1; i<10; i=(cnt==0? i+1 : i+2)) {
			String n = num + Integer.toString(i);
			if(prime(n)) dfs(cnt+1, n);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dfs(0, "");
		
		System.out.println(sb.toString());
	}

}
