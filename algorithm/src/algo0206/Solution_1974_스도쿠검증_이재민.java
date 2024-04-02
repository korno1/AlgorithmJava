package algo0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 완전탐색
 * 20036KB | 117ms
 */
public class Solution_1974_스도쿠검증_이재민 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		StringBuilder sb = new StringBuilder();
		A: for (int tc = 1; tc <= t; tc++) {
			int[][] arr = new int[9][9];
			sb.append("#" + tc + " ");

			for (int i = 0; i < 9; i++) {
				boolean[] check = new boolean[10];
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}

			}

			// 가로
			for (int i = 0; i < 9; i++) {
				boolean[] check = new boolean[10];
				for (int j = 0; j < 9; j++) {
					int x = arr[i][j];
					if (check[x]) {
						sb.append(0).append('\n');
						continue A;
					}
					check[arr[i][j]] = true;
				}
			}

			// 세로
			for (int i = 0; i < 9; i++) {
				boolean[] check = new boolean[10];
				for (int j = 0; j < 9; j++) {
					int x = arr[j][i];
					if (check[x]) {
						sb.append(0).append('\n');
						continue A;
					}
					check[arr[j][i]] = true;
				}
			}

			// 3 by 3씩 9칸으로 나눈다고 생각
			// boolean[구역][숫자]
			boolean[][] area = new boolean[9][10];
			int index = 0;
			for (int i = 0; i < 9; i++) {
				int idx = index;
				for (int j = 0; j < 9; j++) {
					int x = arr[i][j];
					// j >= 6보다 크면 같은 줄의 구간중 3번째 칸
					if(j>=6) idx = index + 2;
					// j >= 3보다 크면 같은 줄의 구간중 2번째 칸
					else if(j>=3) idx = index + 1;
					
					if(area[idx][x]) {
						sb.append(0).append('\n');
						continue A;
					}
					area[idx][x] = true;	
				}
				if(i==2 || i==5) index += 3;
			}

			sb.append(1).append('\n');
		}
		System.out.println(sb.toString());
	}

}
