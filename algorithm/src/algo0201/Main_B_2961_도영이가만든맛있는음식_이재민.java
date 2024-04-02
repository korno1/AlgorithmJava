package algo0201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 바이너리 카운팅 이용
 * (1 << n) 연산은 2^n이 나옴
 * 공집합을 제외해주기 위해 1 ~ 2^n -1 
 */

public class Main_B_2961_도영이가만든맛있는음식_이재민 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = null;

		int[] s = new int[n];
		int[] b = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			s[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}
		int res = Integer.MAX_VALUE;
		
		// 비트마스크
		for (int i = 1; i < (1 << n); i++) {
			int sum1 = 1;
			int sum2 = 0;
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0) {
					sum1 *= s[j];
					sum2 += b[j];
				}
			}
			res = Math.min(res, Math.abs(sum1 - sum2));
		}
		
		System.out.println(res);
	}

}
