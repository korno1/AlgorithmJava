package algo0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 순열을 돌려서 모든 경로를 순회하여 최적 경로 찾기
 * Pair 클래스 사용
 */
public class 최적경로2 {

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
	
	static void permu(int cnt, int sum) {
		if(cnt == n) {
			
			res = Math.min(res, sum);
			
			return ;
		}
		
		for(int i=0; i<n; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			int s = 0;
			if(cnt == 0) {
				s += Math.abs(office.x - cus[i].x) + Math.abs(office.y - cus[i].y);
			}
			else if(cnt == n-1) {
				s += Math.abs(home.x - cus[i].x) + Math.abs(home.y - cus[i].y);
			}
			else {
				s += Math.abs(cus[cnt-1].x - cus[i].x) + Math.abs(cus[cnt-1].y - cus[i].y);
			}
			permu(cnt + 1, sum + s);
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
			
			permu(0, 0);
			sb.append(res).append('\n');
		}
		System.out.println(sb.toString());
	}

}
