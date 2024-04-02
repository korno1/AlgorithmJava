package algo0401;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 현재 위치에서 갈 수 있는 모든 편의점을 q에 넣고
 * 락 페스티벌까지 도착할 수 있는지 bfs 돌리기
 * 20병이 max이기 때문에 갈 수 있는 최대 거리는 1000
 * 편의점에 갈 때 마다 맥주를 전부 채워오기 때문에 최대거리 이하이면 갈 수 있는것으로 판단
 * 12584KB | 100ms
 */

public class Main_B_9205_맥주마시면서걸어가기_이재민 {
	static int N;
	static Loc start, end;
	static List<Loc> list; // 편의점

	static class Loc {
		int x, y;
		boolean check;

		public Loc(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static boolean beer() {
		if (Math.abs(end.x - start.x) + Math.abs(end.y - start.y) <= 1000)
			return true;
		else {
			if(N == 0) return false;
		}
		
		Queue<Loc> q = new ArrayDeque<>();
		q.add(new Loc(start.x, start.y));
		while(!q.isEmpty()) {
			Loc l = q.poll();
			if(Math.abs(l.x - end.x) + Math.abs(l.y - end.y) <= 1000) return true;
			
			for(int i=0; i<N; i++) {
				if(list.get(i).check) continue;
				int nx = list.get(i).x;
				int ny = list.get(i).y;
				if(Math.abs(nx - l.x) + Math.abs(ny - l.y) <= 1000) {
					q.add(new Loc(nx, ny));
					list.get(i).check = true;
				}
			}
		}
		
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		list = new ArrayList<>();
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			list.clear();
			// 출발지점
			st = new StringTokenizer(br.readLine());
			start = new Loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			// 편의점 위치
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.add(new Loc(x, y));
			}

			st = new StringTokenizer(br.readLine());
			end = new Loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			if(beer()) sb.append("happy").append('\n');
			else sb.append("sad").append('\n');
		}
		System.out.println(sb);
	}
}
