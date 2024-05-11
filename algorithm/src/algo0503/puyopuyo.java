package algo0503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class puyopuyo {
	static char map[][];
	static final int N=12, M=6;
	static Queue<Loc> q;
	static Queue<Loc> bombQ;
	static boolean[][] visited;
	static int res;
	static boolean check;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static class Loc{
		int x, y;

		public Loc(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	static boolean rangeCheck(int x, int y) {
		return x>=0 && x<N && y>=0 && y<M;
	}
	
	static void down() {
		for(int i=0; i<M; i++) {
			int idx = N-1;
			// 맨 밑부터 . 찾기
			
			for(int j=N-1; j>=0; j--) {
				if(map[j][i] == '.') {
					idx = j;
					break;
				}
			}
			
			for(int j=idx-1; j>=0; j--) {
				if(map[j][i] != '.') {
					map[idx][i] = map[j][i];
					map[j][i] = '.';
					idx--;
				}
			}
		}
	}

	static void bomb(int x, int y) {
		q.clear();
		bombQ.clear();
		visited = new boolean[N][M];
		
		q.add(new Loc(x, y));
		bombQ.add(new Loc(x, y));
		visited[x][y] = true;

		while(!q.isEmpty()) {
			Loc l = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = l.x + dx[i];
				int ny = l.y + dy[i];
				if(!rangeCheck(nx, ny)) continue;
				if(visited[nx][ny]) continue;
				if(map[x][y] != map[nx][ny]) continue;
				
				visited[nx][ny] = true;
				q.add(new Loc(nx, ny));
				bombQ.add(new Loc(nx, ny));
				
			}
		}
		
		if(bombQ.size()>=4) {
			check = true;
			while(!bombQ.isEmpty()) {
				Loc l = bombQ.poll();
				map[l.x][l.y] = '.';
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[N][M];
		q = new ArrayDeque<>();
		bombQ = new ArrayDeque<>();
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			map[i] = line.toCharArray();
		}

		while(true) {
			check = false;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] != '.') {
						bomb(i, j);
					}
				}
			}
			if(!check) break;
			res++;
			down();
			
			
		}
		
		System.out.println(res);
	}
}
