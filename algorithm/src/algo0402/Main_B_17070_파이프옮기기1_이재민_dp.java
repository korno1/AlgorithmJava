package algo0402;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * dp
 * 현재 지점을 올 수 있는 칸을 가로 세로 대각선으로 나눔
 * 가로로 올때는 이전칸에서 가로와 대각선으로 배치되어 있는 파이프만 올 수 있음
 * 세로 대각선도 똑같이 생각
 * 11632KB | 76ms
 */
public class Main_B_17070_파이프옮기기1_이재민_dp {
	static int N;
	static int[][] map;
	static int[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		dp = new int[N][N][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][1][0] = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 2; j < N; j++) {
				if (map[i][j] != 0)
					continue;
				// 가로
				dp[i][j][0] += dp[i][j - 1][0] + dp[i][j - 1][2];
				// 세로
				if(i==0) continue;
				dp[i][j][1] += dp[i-1][j][1] + dp[i-1][j][2];
				
				if(map[i-1][j] != 0 || map[i][j-1] != 0) continue;
				dp[i][j][2] += dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
			}
		}
		
		
		
		System.out.println(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]);
	}

}
