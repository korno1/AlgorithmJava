package algo0201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 22108KB | 4198ms
 * 순열 구하기
 */
public class Solution_6808_규영이와인영이의카드게임_이재민 {

	static int n;
	static int res;
	static int[] picked;
	static boolean[] visited;
	static List<Integer> list1;
	static List<Integer> list2;

	static void permu(int cnt) {
		if (cnt == n) {
			int p1 = 0;
			int p2 = 0;
			for (int i = 0; i < n; i++) {
				if (list1.get(i) > picked[i]) {
					p1 += list1.get(i) + picked[i];
				} else if (list1.get(i) < picked[i])
					p2 += picked[i] + list1.get(i);
			}

			if (p1 > p2)
				res++;

			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			picked[cnt] = list2.get(i);
			permu(cnt + 1);
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());


		StringTokenizer st = null;
		for (int tc = 1; tc <= t; tc++) {
			n = 9;
			res = 0;
			picked = new int[n];
			visited = new boolean[n];
			int total = 1;
			for (int i = n; i > 0; i--) {
				total *= i;
			}
			st = new StringTokenizer(br.readLine());
			list1 = new ArrayList<>();
			list2 = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				list1.add(Integer.parseInt(st.nextToken()));
			}

			for (int i = 1; i <= n * 2; i++) {
				if (!list1.contains(i)) {
					list2.add(i);
				}
			}

			permu(0);
			
			System.out.println("#" + tc + " " + res + " " + Math.abs((total - res)));
		}

	}

}
