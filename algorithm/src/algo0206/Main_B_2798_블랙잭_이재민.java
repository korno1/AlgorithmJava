package algo0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 5개 중 3개를 뽑기 (순서가 달라도 같다고 보기)
 * 3개를 더해서 M을 넘지 않고 M에 가까운 최대 합
 * 재귀를 이용하여 sum값을 갱신
 * 11576KB | 80ms
 */

public class Main_B_2798_블랙잭_이재민 {
	static int res;
	static int n, m;
	static int[] arr;
	
	public static void combi(int cnt, int idx,int sum) {
		if(cnt==3) {
			if(sum <= m) {
				res = Math.max(res, sum);
			}
			return ;
		}
		
		for(int i=idx; i<n; i++) {
			combi(cnt+1, i+1, sum + arr[i]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		combi(0, 0, 0);
		
		System.out.println(res);
		
	}

}
