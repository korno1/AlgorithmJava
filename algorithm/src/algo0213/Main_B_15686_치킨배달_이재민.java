package algo0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 치킨집을 조합으로 뽑고 집을 기준으로
 * 모든 치킨집과의 거리를 구해서 가장 작은 값을 갱신
 * 14408KB | 160ms
 */

public class Main_B_15686_치킨배달_이재민 {

	static int N, M;
	static List<Pair> home;
	static List<Pair> store;
	static Pair[] picked;
	static int res;

	static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void combi(int cnt, int idx) {
		if(cnt == M) {
			int sum = 0;
			for(int i=0; i<home.size(); i++) {
				int dist = Integer.MAX_VALUE;
				for(int j=0; j<M; j++) {
					int r = picked[j].x;
					int c = picked[j].y;
					int d = Math.abs(home.get(i).x - r) + (Math.abs(home.get(i).y - c));
					dist = Math.min(dist, d);
				}
				sum += dist;
			}
			res = Math.min(sum, res);
			return ;
		}
		
		for(int i=idx; i<store.size(); i++) {
			picked[cnt] = store.get(i);
			combi(cnt+1, i+1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		home = new ArrayList<>();
		store = new ArrayList<>();
		picked = new Pair[M];
		res = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int input = Integer.parseInt(st.nextToken());
				if (input == 1)
					home.add(new Pair(i, j));
				else if (input == 2)
					store.add(new Pair(i, j));
			}
		}
		combi(0, 0);
		System.out.println(res);
	}

}
