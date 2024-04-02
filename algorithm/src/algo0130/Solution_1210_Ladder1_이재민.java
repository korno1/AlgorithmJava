package algo0130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1210_Ladder1_이재민 {

	static int d[][] = {{-1, 0}, {0,-1}, {0, 1}};
	
	static public class Pair{
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static boolean check(int x, int y, int[][] map) {
		if(x<0 || x>=100) return false;
		if(y<0 || y>=100) return false;
		if(map[x][y] == 0) return false;
		return true;
	}
	
	static int bfs(int i, int j, int[][] map) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(i, j));
		int dir = 0;
		int res = 0;
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.remove();
			
			if(x-1 < 0) {
				res = y;
				break;
			}
			
			// 아래로 내려가고 있을 때 좌우 경로로 갈 수 있으면
			if(dir == 0) {
				int leftX = x;
				int leftY = y + d[1][1];
				if(check(leftX, leftY, map)) {
					dir = 1;
				}
				int rightX = x;
				int rightY = y + d[2][1];
				if(check(rightX, rightY, map)) {
					dir = 2;
				}
			}
			// 좌우로 가고 있을때 가지 못하는 경로라면 아래로
			else {
				int nx = x + d[dir][0];
				int ny = y + d[dir][1];
				if(!check(nx, ny, map)) {
					dir = 0;
				}
			}
			
			int nx = x + d[dir][0];
			int ny = y + d[dir][1];
			q.add(new Pair(nx, ny));
			
			
			
		}
		return res;
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc<=10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int res = 0;
			int[][] map = new int[100][100];
			
			for(int i=0; i<100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 2) {
						res = bfs(i, j, map);
						break;
					}
				}
			}
			
		
			System.out.println("#" + tc + " " + res);
			
		}
	}

}
