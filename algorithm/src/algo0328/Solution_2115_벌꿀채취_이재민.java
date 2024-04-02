package algo0328;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 새로운 배열에다가 조건에 맞춘 계산값을 미리 구해놓기
 * 26692KB | 129ms
 */
public class Solution_2115_벌꿀채취_이재민 {
	
	static int N, M, C;
	static int[][] map, s;
	static int[] subset;
	static int res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
		
			map = new int[N][N];
			s = new int [N][N];
			res = 0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<=N-M; j++) {
					subset = new int[M];
					int idx = 0;
					for(int k=j; k<j+M; k++) {
						subset[idx++] = map[i][k];
					}
					A: for(int k=1; k<(1<<M); k++) {
						int sum = 0;
						int pow = 0;
						for(int p=0; p<M; p++) {
							if((k & (1 << p)) != 0) {
								sum += subset[p];
								pow += subset[p] * subset[p];
								if(sum > C) continue A;
							}
						}
						
						s[i][j] = Math.max(s[i][j], pow);
					}
					
					
				}
			}
			
			for(int i=0; i<N*N-M; i++) {
				for(int j=i+M; j<N*N; j++) {
					if(res < s[i/N][i%N] + s[j/N][j%N])
						res =  s[i/N][i%N] + s[j/N][j%N];
				}
			}
			sb.append(res).append('\n');
		}
		System.out.println(sb);
	}

}
