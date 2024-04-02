package algo0327;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2중 포문을 이용한 최장증가부분수열
 * 39008KB | 173ms
 */
public class Solution_3307_최장증가부분수열_이재민 {

	static int N;
	static int[] arr, dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
			sb.append("#" + tc + " ");
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			dp = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			for(int i=0; i<N; i++) {
				dp[i] = 1;
				for(int j=0; j<i; j++) {
					if(arr[i] > arr[j]) {
						dp[i] = Math.max(dp[i], dp[j] + 1);
						if(dp[i] > max) max = dp[i];
					}
				}
			}
			sb.append(max).append('\n');
		}
		System.out.println(sb);
	}	
}
