
package algo0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * disjointset을 사용하여 union으로 합치고
 * findset으로 같은 집합인지 확인
 * 101032KB | 406ms
 */
public class Solution_3289_서로소집합_이재민 {

	static int N; // 1~N 정점
	static int M; // 합집합 정보 개수

	static int[] parents; // 서로소 집합 정보

	private static void makeSet() {
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++)
			parents[i] = i;
	}

	private static int findSet(int x) {
		if (parents[x] == x)
			return x;
		return parents[x] = findSet(parents[x]);
	}

	private static void union(int a, int b) {
		a = findSet(a);
		b = findSet(b);

		if(a == b) return;
		
		if (a > b)
			parents[a] = b;
		else
			parents[b] = a;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			
			sb.append("#" + tc + " ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			makeSet();

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if (command == 0)
					union(a, b);
				else {
					if(findSet(a) == findSet(b)) sb.append(1);
					else sb.append(0);
				}
			}

			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

}
