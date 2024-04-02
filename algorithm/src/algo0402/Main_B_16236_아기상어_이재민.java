package algo0402;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 문제에서 주어진 대로 구현
 * 최단거리에 있는 물고기들을 리스트에 저장하여 정렬 후
 * 조건에 맞는 물고기를 섭취
 * 12136KB | 88ms
 */

public class Main_B_16236_아기상어_이재민 {
	static int N, sx, sy, sSize;
	static int[][] map;
	static List<Loc> fish; // 가까운 물고기 저장용

	static int[] dx = { -1, 0, 0, 1 }; // 상 좌 우 하
	static int[] dy = { 0, -1, 1, 0 }; // 상 좌 우 하
	static boolean[][] visited;
	static Queue<int[]> q;

	static class Loc implements Comparable<Loc> {
		int x, y, dist;

		public Loc(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(Loc o) {
			if (this.dist == o.dist) {
				if (this.x == o.x) {
					return this.y - o.y;
				}
				return this.x - o.x;
			}
			return this.dist - o.dist;
		}
	}

	static boolean rangeCheck(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

	static void bfs() {

		q.clear();
		q.add(new int[] { sx, sy, 0 });
		boolean check = false;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int k = 0; k < size; k++) {
				int x = q.peek()[0];
				int y = q.peek()[1];
				int dist = q.poll()[2];

				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (!rangeCheck(nx, ny))
						continue;
					if (visited[nx][ny])
						continue;

					visited[nx][ny] = true;

					if (sSize >= map[nx][ny]) {
						if (map[nx][ny] != 0 && sSize != map[nx][ny]) {
							check = true;
							fish.add(new Loc(nx, ny, dist + 1));
						}
						q.add(new int[] { nx, ny, dist + 1 });
					}

				}
			}
			if (check)
				break;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		fish = new ArrayList<>();
		sSize = 2;
		q = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					sx = i;
					sy = j;
					map[i][j] = 0;
				}
			}
		}

		int time = 0;
		int cnt = 0; // 상어 성장

		while (true) {
			visited = new boolean[N][N];
			fish.clear();
			bfs();

			if (fish.isEmpty())
				break;

			Collections.sort(fish);

			int dist = fish.get(0).dist;
			sx = fish.get(0).x;
			sy = fish.get(0).y;
			map[sx][sy] = 0;
			time += dist;

			cnt++;
			if (cnt == sSize) {
				cnt = 0;
				sSize++;
			}

		}

		System.out.println(time);
	}
}
