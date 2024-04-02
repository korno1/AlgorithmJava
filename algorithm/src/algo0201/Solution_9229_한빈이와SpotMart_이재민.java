package algo0201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 완전탐색
 * 30596KB | 198ms
 */

public class Solution_9229_한빈이와SpotMart_이재민 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int max_res = -1;

			for(int i=0; i<n; i++) {
				for(int j=i+1; j<n; j++) {
					int x = arr[i] + arr[j];
					if(x <= m) {
						max_res = Math.max(x, max_res);
					}
				}
			}
			
			System.out.println("#" + tc + " " + max_res);
		}
	}

}
