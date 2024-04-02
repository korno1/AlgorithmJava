import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백조의호수 {
	static int R, C;
	static char[][] map;
	static int res;
	static int start[];

	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static int idx;
	static boolean[][] visited;
	static boolean[][] dfsVisited;
	
	static boolean rangeCheck(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}
	
	
	static void dfs(int x, int y) {
		dfsVisited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(!rangeCheck(nx, ny)) continue;
			if(dfsVisited[nx][ny]) continue;
			
			if(map[nx][ny] == 'L') {
				System.out.println(res);
				System.exit(0);
			}
			
			if(map[nx][ny] == '.') {
				dfs(nx, ny);
			}
		}	
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		Queue<int[]> q = new ArrayDeque<>();
		map = new char[R][C];
		start = new int[2];
		res = 0;
		
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == 'L') {
					start[0] = i;
					start[1] = j;
				}
				if(map[i][j] == 'X') q.add(new int[] {i, j});
			}
		}
		while (true) {
			dfsVisited = new boolean[R][C];
			dfs(start[0], start[1]);
			int size = q.size();
			visited = new boolean[R][C];
			
			A: for(int t = 0; t<size; t++) {
				int x = q.peek()[0];
				int y = q.poll()[1];
				
				if(visited[x][y]) {
//					q.add(new int[] {x, y});
					continue;
				}
				for(int i=0; i<4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if(!rangeCheck(nx, ny)) continue;
					if(visited[nx][ny]) continue;
					if(map[nx][ny] == '.') {
						map[x][y] = '.';
						visited[x][y] = true;
						continue A;
					}
				}
				q.add(new int[] {x, y});
			}
			res++;
		}
//		System.out.println(res);
	}
}