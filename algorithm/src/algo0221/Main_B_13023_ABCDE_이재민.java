package algo0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/*
 * for문을 돌려 시작 지점을 돌려가며 dfs 돌리기
 * cnt==5이면 문제 조건에 부합하는 관계가 있다는 뜻이므로 출력하고 바로 종료
 * 14156KB | 204ms
 */
public class Main_B_13023_ABCDE_이재민 {
	static int N, M;
	static List<Integer>[] list;

	static void dfs(int x, int cnt, int isUsed) {
		if(cnt == 5) {
			System.out.println(1);
			System.exit(0);
		}
		
		for (int i = 0; i < list[x].size(); i++) {
			int nx = list[x].get(i);
			
			if ((isUsed & (1 << nx)) != 0) continue;
			
			dfs(nx, cnt + 1, isUsed | (1 << nx));
			
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		char a = st.nextToken().charAt(0);
		list = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			list[x].add(y);
			list[y].add(x);
		}
		for(int i=0; i<N; i++) {
			dfs(i, 1, 1 << i);
		}
		System.out.println(0);
	}

}
