package algo0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 순열을 돌려서 모든 경로를 순회하여 최적 경로 찾기
 * Pair 클래스 사용
 * 20672KB | 1888ms
 */
public class Solution_1247_최적경로_이재민 {

	static class Pair{
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static boolean[] visited;
	static int n; 
	static Pair office, home, cus[], picked[]; // 회사, 집, 고객, 선택배열
	static int res; // 결과값 저장
	
	static void permu(int cnt) {
		if(cnt == n) {
			int sum = 0;
			
			// 회사에서 첫번째 고객 집
			sum += Math.abs(office.x - picked[0].x) + Math.abs(office.y - picked[0].y);
			// 고객 -> 고객
			for(int i=0; i<n-1; i++) {
				sum += Math.abs(picked[i].x - picked[i+1].x) + Math.abs(picked[i].y - picked[i+1].y);
			}
			// 마지막 고객 집에서 집
			sum += Math.abs(home.x - picked[n-1].x) + Math.abs(home.y - picked[n-1].y);
			
			res = Math.min(res, sum);
			
			return ;
		}
		
		for(int i=0; i<n; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			picked[cnt] = cus[i];
			permu(cnt + 1);
			visited[i] = false;
			
		}
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=t; tc++) {
			sb.append("#" + tc + " ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			office = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			cus = new Pair[n];
			picked = new Pair[n];
			visited = new boolean[n];
			res = Integer.MAX_VALUE;
			
			
			for(int i=0; i<n; i++) {
				cus[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			permu(0);
			sb.append(res).append('\n');
		}
		System.out.println(sb.toString());
	}

}
