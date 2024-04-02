package algo0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * 구간합을 구해서 1과 0을 판단하는 코드를 없앰
 * 구하고자 하는 부분에서 합이 N*N이면 전부 1 합이 0이면 전부 0임
 * 11680KB | 84ms
 */
public class Main_B_1992_쿼드트리_이재민 {

	static int arr[][];
	static StringBuilder sb = new StringBuilder();
	public static void dfs(int r, int c, int N) {
		
		int sum = arr[r+N-1][c+N-1] - arr[r-1][c+N-1] - arr[r+N-1][c-1] + arr[r-1][c-1];
		if(sum == N*N) {
			sb.append(1);
			return ;
		}
		else if(sum == 0) {
			sb.append(0);
			return ;
		}
		
		sb.append("(");
		dfs(r, c, N/2);
		
		dfs(r, c+N/2, N/2);

		dfs(r+N/2, c, N/2);
		
		dfs(r+N/2, c+N/2, N/2);
		sb.append(")");
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); 
		
		arr = new int[N+1][N+1];
		
		
		for(int i=1; i<=N; i++) {
			String line = br.readLine();
			for(int j=1; j<=N; j++) {
				arr[i][j] = arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1] + (line.charAt(j-1) - '0');
			}
		}
		
		dfs(1, 1, N);
		
		System.out.println(sb.toString());
		
	}

}
