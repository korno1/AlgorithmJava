package algo0327;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 열쇠 체크 -> bitmask 사용
 * 방문체크 -> 3차원 배열 사용
 * bfs
 * 135288KB | 272ms
 */
public class Main_B_1194_달이차오른다가자_이재민 {
	static int N, M;
	static char[][] map;
//	static int key;
	static Queue<Loc> q;
	static boolean[][][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static boolean rangeCheck(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

	static void bfs() {
//		System.out.println(q.size());
		while (!q.isEmpty()) {
			Loc l = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = l.x + dx[i];
				int ny = l.y + dy[i];
				if (!rangeCheck(nx, ny))
					continue;
				if (map[nx][ny] == '1') {
					System.out.println(l.d + 1);
					System.exit(0);
				}
				if (map[nx][ny] == '#')
					continue;
				
				if(visited[nx][ny][l.key]) continue; 

				if (map[nx][ny] >= 'a' && map[nx][ny] <= 'f') {
					q.add(new Loc(nx, ny, l.d + 1, l.key | (1 << (map[nx][ny] - 'a'))));
					visited[nx][ny][l.key] = true;
				}

				else if (map[nx][ny] >= 'A' && map[nx][ny] <= 'F') {
					if ((l.key & (1 << (map[nx][ny] - 'A'))) != 0) {
						q.add(new Loc(nx, ny, l.d + 1, l.key));
						visited[nx][ny][l.key] = true;
					}
				}
				else {
					q.add(new Loc(nx, ny, l.d + 1, l.key));
					visited[nx][ny][l.key] = true;
				}

			}
		}
		System.out.println(-1);
		System.exit(0);
	}

	static class Loc {
		int x, y, d, key;
		boolean visited[][];
		public Loc(int x, int y, int d, int key) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.key = key;
			visited = new boolean[N][M];
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		q = new ArrayDeque<>();
		visited = new boolean[N][M][64];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == '0') {
					q.add(new Loc(i, j, 0, 0));
					map[i][j] = '.';
				}
			}
		}

		bfs();

	}

}
