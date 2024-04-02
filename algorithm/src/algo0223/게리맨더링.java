package algo0223;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 게리맨더링 {
	static int N;
	static int[] pNum; // 인구수
	static List<Integer> list[];
	static int res = Integer.MAX_VALUE;
	static int areaA, areaB, cntA, cntB;
	static boolean picked[], visited[];

	public static void subset() {
		for (int i = 1; i < (1 << N)/2; i++) {
			Arrays.fill(picked, false);
			areaA = 0;
			areaB = 0;
			cntA = 0;
			cntB = 0;
			int startA = 0;
			int startB = 0;
			
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0) {
					areaA += pNum[j+1];
					cntA++;
					picked[j+1] = true;
					startA = j+1;
				} else {
					areaA -= pNum[j+1];
					cntB++;
					startB = j+1;
				}
			}
			Arrays.fill(visited, false);
			dfs(startA, true);
			if(cntA != 0) continue;
			dfs(startB, false);

			if (cntA == 0 && cntB == 0) {
				res = Math.min(res, Math.abs(areaA));
			}
		}
	}

	public static void dfs(int x, boolean flag) {
		visited[x] = true;
		if(flag) cntA--;
		else cntB--;
		for (int nx : list[x]) {
			if (!visited[nx] && picked[nx] && flag) {
				dfs(nx, flag);
			}
			else if (!visited[nx] && !picked[nx] && !flag) {
				dfs(nx, flag);
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