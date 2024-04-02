package algo0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


/*
 * 익은 토마토를 전부 큐에 넣고 동시에 돌림
 * tNum이라는 안익은 토마토의 개수를 세어놓는 변수를 만들고
 * BFS를 다 돌았을 때 tNum이 0이면 전부 다 익은걸로 판정
 * 아니면 -1 출력
 * 100604KB | 536ms
 */
public class Main_B_7576_토마토_BFS_이재민 {
	static int N, M, res, tNum;
	static int[][] tomato;
	// 상하좌우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static Queue<tInfo> q;
	
	static class tInfo{
		int x, y, d;

		public tInfo(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
		
	}

	
	static boolean moveCheck(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M && tomato[x][y]==0;
	}
	
	static void bfs() {
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			int d = q.poll().d;
			res = Math.max(res, d);
			
			for(int idx=0; idx<4; idx++) {
				int nx = x + dx[idx];
				int ny = y + dy[idx];
				if(moveCheck(nx, ny)) {
					tNum--;
					tomato[nx][ny] = 1;
					q.add(new tInfo(nx, ny, d+1));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		q = new ArrayDeque<>();
		tomato = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(tomato[i][j] == 1) q.add(new tInfo(i, j, 0));
				else if(tomato[i][j] == 0) tNum++;
			}
		}
		
		bfs();
		
		System.out.println(tNum == 0 ? res : -1);
		
	}

}
