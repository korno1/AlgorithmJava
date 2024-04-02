package algo0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_B_17471_게리맨더링_이재민 {
	static int N;
	static int[] pNum; // 인구수
	static List<Integer> list[];
	static int res = Integer.MAX_VALUE;
	static int areaA, areaB, cA, cB;
	static boolean picked[], visited[];

	public static void subset() {
		for (int i = 1; i < (1 << N); i++) {
			Arrays.fill(picked, false);
			areaA = 0;
			areaB = 0;
			cA = 0;
			cB = 0;
			int cntA = 0;
			int cntB = 0;
			int startA = 0;
			int startB = 0;
			for (int j = 1; j <= N; j++) {
				if ((i & (1 << j)) != 0) {
					areaA += pNum[j];
					cntA++;
					picked[j] = true;
					startA = j;
				} else {
					areaB += pNum[j];
					cntB++;
					startB = j;
				}
			}
			Arrays.fill(visited, false);
			Adfs(startA, visited);
			Bdfs(startB, visited);

			if (cA == cntA && cB == cntB) {
				res = Math.min(res, Math.abs(areaA - areaB));
			}
		}
	}

	public static void Adfs(int x, boolean[] visited) {
		visited[x] = true;
		cA++;
		for (int nx : list[x]) {
			if (!visited[nx] && picked[nx]) {
				Adfs(nx, visited);
			}
		}
	}

	public static void Bdfs(int x, boolean[] visited) {
		visited[x] = true;
		cB++;
		for (int nx : list[x]) {
			if (!visited[nx] && !picked[nx]) {
				Bdfs(nx, visited);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		pNum = new int[N + 1];
		picked = new boolean[N + 1];
		visited = new boolean[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			pNum[i] = Integer.parseInt(st.nextToken());
		}

		list = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int range = Integer.parseInt(st.nextToken());
			for (int j = 0; j < range; j++) {
				int x = Integer.parseInt(st.nextToken());
				list[i].add(x);
				list[x].add(i);
			}
		}

		subset();

		System.out.println(res == Integer.MAX_VALUE ? -1 : res);

	}

}