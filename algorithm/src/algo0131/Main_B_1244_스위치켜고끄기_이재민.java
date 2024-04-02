package algo0131;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 남학생이면 for문을 돌아서 배수의 범위를 벗어나지 않는 부분에서 스위치를 바꿔주고
 * 여학생이면 양쪽을 계속 체킹해서 대칭이 아닐때까지 while문을 돌린다
 * 대칭이면 스위치를 바꾸면서 이동
 * 11612KB | 76ms
 */

public class Main_B_1244_스위치켜고끄기_이재민 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] s = new int[n+1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			s[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			if (x == 1) {
				for (int j = num; j <= n; j += num) {
					s[j] = Math.abs(s[j] - 1);
				}
			} 
			else {
				s[num] = Math.abs(s[num] - 1);
				for (int j = 1; j <= n; j++) {
					if (num - j >= 1 && num + j <= n) {
						if (s[num + j] == s[num - j]) {
							s[num + j] = Math.abs(s[num + j] - 1);
							s[num - j] = Math.abs(s[num - j] - 1);
						}
						else break;
					}
				}
			}
		}
		
		for(int i=1; i<=n; i++) {
			System.out.print(s[i] + " ");
			if(i%20==0) System.out.println();
		}
	}

}
