package algo0401;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백트래킹
 * 봉우리 높은 지점에서 시작해서
 * 다음에 가는 지점이 낮으면 깎을필요 없이 그냥 가는게 좋기 때문에 그냥 가고
 * 높으면 1부터 K까지 깎아봄
 * 낮게 깎았을때 갈 수 있는 지점이면 제일 좋기 때문에
 * 깎아서 갈 수 있으면 바로 break
 * 24204KB | 112ms
 */
public class Solution_1949_등산로조성_이재민 {

	static int N, K, res;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visited;
	static class Loc {
		int x, y;

		public Loc(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	static boolean rangeCheck(int x, int y) {
		return x>=0 && x<N && y>=0 && y<N;
	}
	
	static void dfs(int x, int y, int cnt, boolean check) {
		if(cnt > res) res = cnt;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(!rangeCheck(nx, ny)) continue;
			if(visited[nx][ny]) continue;;
			if(map[nx][ny] < map[x][y]) {
				visited[nx][ny] = true;
				dfs(nx, ny, cnt+1, check);
				visited[nx][ny] = false;
			}
			
			else {
				if(!check) {
					for(int j=1; j<=K; j++) {
						if(map[nx][ny] - j < map[x][y]) {
							map[nx][ny] -= j;
							visited[nx][ny] = true;
							dfs(nx, ny, cnt+1, true);
							visited[nx][ny] = false;
							map[nx][ny] += j;
							break;
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			sb.append("#" + tc + " ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			res = 0;
			map = new int[N][N];
			visited = new boolean[N][N];
			int max = 0;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] > max) {
						max = map[i][j];
					}
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == max) {
						visited[i][j] = true;
						dfs(i, j, 1, false);
						visited[i][j] = false;
					}
				}
			}
			
			sb.append(res).append('\n');
			
			
		}
		System.out.println(sb);
	}

}
