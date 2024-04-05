package algo0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 각 국가에서 다른 국가를 상대로 이기고 비기고 지는 것을 완전 탐색
 * 이기는 팀은 win[]-- 지는 팀은 lose[]--를 해주고 재귀를 실행 후 win[]++ lose[]++로 다시 되돌려줌
 * 무승부도 똑같이 수행
 * 총 경기수가 15경기니까 cnt가 15로 들어가면 되는 경기고
 * cnt가 15가 되는게 없다면 불가능
 *  11576KB | 80ms
 */

public class Main_B_6987_월드컵_이재민 {
	static final int N = 4;
	static int[] win, draw, lose;
	static boolean check;
	static int cnt;
	

	static void dfs(int cnt, int f, int b) {
		if (check)
			return;

		if (cnt == 15) {
			check = true;
			return;
		}

		// 앞팀이 이김
		if (win[f] > 0 && lose[b] > 0) {
			win[f]--;
			lose[b]--;
			if (b == 5)
				dfs(cnt + 1, f + 1, f + 2);
			else
				dfs(cnt + 1, f, b + 1);
			win[f]++;
			lose[b]++;
		}

		// 비김
		if (draw[f] > 0 && draw[b] > 0) {
			draw[f]--;
			draw[b]--;
			if (b == 5)
				dfs(cnt + 1, f + 1, f + 2);
			else
				dfs(cnt + 1, f, b + 1);
			draw[f]++;
			draw[b]++;
		}

		// 앞팀이 짐
		if (win[b] > 0 && lose[f] > 0) {
			win[b]--;
			lose[f]--;
			if (b == 5)
				dfs(cnt + 1, f + 1, f + 2);
			else
				dfs(cnt + 1, f, b + 1);
			win[b]++;
			lose[f]++;
		}

		if (b == 5) {
			if (f == 5)
				return;
			f++;
			b = f+1;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			win = new int[6];
			draw = new int[6];
			lose = new int[6];
			check = false;
			boolean five = true;
			for (int j = 0; j < 6; j++) {
				win[j] = Integer.parseInt(st.nextToken());
				draw[j] = Integer.parseInt(st.nextToken());
				lose[j] = Integer.parseInt(st.nextToken());
				
				// 한 국가의 총 경기수가 5가 되지 않으면 안되는걸로 판단
				if(win[j] + draw[j] + lose[j] != 5) five = false;
			}
			if(!five) {
				sb.append("0 ");
				continue;
			}
			dfs(0, 0, 1);
			sb.append(check ? "1 " : "0 ");

		}
		System.out.println(sb);

	}

}
