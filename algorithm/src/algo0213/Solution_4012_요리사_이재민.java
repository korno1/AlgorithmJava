package algo0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * bool 배열로 음식1과 2를 판단
 * 둘다 true면 음식1, 둘다 false면 음식2
 * 만약 123이 나왔는데 이후 456을 뽑으면 456이 음식1이 됨 (중복)
 * 조합의 처음이 1부터 시작하지 않으면 음식 2가 예전에 음식 1이었던 조합이 됨
 * ex) 1 3 5 2 4 6 -> 2 4 6 1 3 5
 * 처음 배열은 true로 두고 나머지 개수를 조합으로 뽑기
 * 22312KB | 186ms
 */

public class Solution_4012_요리사_이재민 {
	static int N;
	static int[] picked;
	static int[][] arr; // 식재료
	static boolean[] visited;
	static int res;

	public static void combi(int cnt, int idx) {
		if(cnt == N/2) {
			int sum1 = 0;
			int sum2 = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					if(visited[i] && visited[j]) {
						sum1 += arr[i][j] + arr[j][i];
					}
					else if(!visited[i] && !visited[j]) {
						sum2 += arr[i][j] + arr[j][i];
					}
				}
			}
			res = Math.min(res, Math.abs(sum1 - sum2));
			return ;
		}
		
		for(int i=idx; i<N; i++) {
			visited[i] = true;
			combi(cnt+1, i+1);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N][N];
			picked = new int[N/2];
			visited = new boolean[N];
			res = Integer.MAX_VALUE;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			visited[0] = true;
			combi(1, 1);
			sb.append("#" + tc + " " + res).append('\n');
		}
		System.out.println(sb.toString());
	}

}
