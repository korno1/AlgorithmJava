package algo0328;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 플로이드워셜
 * 106716KB | 3945ms
 */
public class Solution_1263_사람네트워크2_이재민 {
	static int N;
	static int[][] d;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			d = new int[N+1][N+1];
			res = Integer.MAX_VALUE;
			
			sb.append("#" + tc + " ");
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					d[i][j] = Integer.parseInt(st.nextToken());
					if(i != j && d[i][j] == 0) {
						d[i][j] = 100000000;
					}
					if(i==j) d[i][j] = 0;
				}
			}
			
			for(int k=1; k<=N; k++) {
				for(int i=1; i<=N; i++) {
//					if(i==k) continue;
					for(int j=1; j<=N; j++) {
						if(i==j || j==k) continue;
						d[i][j] = Math.min(d[i][k] + d[k][j], d[i][j]);
					}
				}
			}
			
			for(int i=1; i<=N; i++) {
				int sum = 0;
				for(int j=1; j<=N; j++) {
					sum += d[i][j];
				}
				res = Math.min(res, sum);
			}
			
			sb.append(res).append('\n');
		}
		System.out.println(sb);
	}

}
