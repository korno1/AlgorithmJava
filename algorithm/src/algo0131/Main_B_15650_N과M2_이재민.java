package algo0131;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 중복 없는 조합을 고르는 문제
 * 백트래킹을 이용해 조합을 구하고 (자동적으로 오름차순) 
 * 출력
 * 11520KB | 80ms
 */

public class Main_B_15650_N과M2_이재민 {
	
	static StringBuilder sb;
	static boolean[] check;
	static int[] arr;
	static int n, m;
	
	static void combi(int cnt, int idx) {
		if(cnt == m) {
			Arrays.stream(arr).forEach(x -> {
				sb.append(x + " ");
			});
			sb.append('\n');
			
			return ;
		}
		// 중복을 허용하지 않으니 i+1을 idx로 넘겨줌
		for(int i=idx; i<=n; i++) {
			arr[cnt] = i;
			combi(cnt+1, i+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		check = new boolean[n+1];
		sb = new StringBuilder();
		arr = new int[m];
		
		combi(0, 1);
		
		System.out.println(sb.toString());
		
		
	}

}
