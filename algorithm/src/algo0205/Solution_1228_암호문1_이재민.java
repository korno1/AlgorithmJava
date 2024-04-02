package algo0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * List의 index를 이용한 add 사용
 * 18900KB | 107ms
 */

public class Solution_1228_암호문1_이재민 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			List<String> list = new LinkedList<String>();

			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < n; i++) {
				list.add(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			int cN = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < cN; i++) {
				st.nextToken().charAt(0);
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				for (int j = 0; j < y; j++) {
					list.add(x++, st.nextToken());
				}

			}

			sb.append("#" + tc + " ");
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i) + " ");
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
		
	}

}
