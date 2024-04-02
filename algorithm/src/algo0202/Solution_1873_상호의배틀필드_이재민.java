package algo0202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문자열 주어진대로 수행
 * 미리 방향 값을 저장해놓고 상하좌우에 따라 값을 넣어줌
 * class를 하나 만들어 방향 값을 저장해주고
 * curX와 curY 변수를 만들어서 현재 전차의 위치를 나타냄
 * 32248 kb | 186 ms
 */

public class Solution_1873_상호의배틀필드_이재민 {
	static int[][] d = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static char[][] map;
	static int h, w, curX, curY; 
	static int dir;
	static Pair p;
	static class Pair {
		int xDir, yDir;

		public Pair(int xDir, int yDir) {
			this.xDir = xDir;
			this.yDir = yDir;
		}
	}

	static boolean check(int x, int y) {
		if (x < 0 || x >= h || y < 0 || y >= w)
			return false;
		if (map[x][y] == '*' || map[x][y] == '#' || map[x][y] == '-')
			return false;
		return true;
	}
	
	static void move() {
		map[curX][curY] = '.';
		curX += p.xDir;
		curY += p.yDir;
	}
	
	static void changeDir() {
		p.xDir = d[dir][0]; p.yDir = d[dir][1];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			p = new Pair(0, 0);

			map = new char[h][w];

			for (int i = 0; i < h; i++) {
				String line = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = line.charAt(j);
					if (map[i][j] == '^') {
						dir = 0;
						changeDir();
						curX = i; curY = j;
					} else if (map[i][j] == 'v') {
						dir = 1;
						changeDir();
						curX = i; curY = j;
					} else if (map[i][j] == '<') {
						dir = 2;
						changeDir();
						curX = i; curY = j;
					} else if (map[i][j] == '>') {
						dir = 3;
						changeDir();
						curX = i; curY = j;
					}
				}
			}
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String input = br.readLine();

			for (int i = 0; i < N; i++) {
				switch (input.charAt(i)) {
				case 'U':
					dir = 0;
					changeDir(); // 방향전환
					// 이동할 수 있는 위치인지 체크하고 이동할 수 있으면 현재위치를 평지로 바꾸고 이동
					if (check(curX + p.xDir, curY + p.yDir)) move();
					map[curX][curY] = '^';
					break;
	
				case 'D':
					dir = 1;
					changeDir();
					if (check(curX + p.xDir, curY + p.yDir)) move();
					map[curX][curY] = 'v';
					break;
				
				case 'L':
					dir = 2;
					changeDir();
					if (check(curX + p.xDir, curY + p.yDir)) move();
					map[curX][curY] = '<';
					break;
				
				case 'R':
					dir = 3;
					changeDir();
					if (check(curX + p.xDir, curY + p.yDir)) move();
					map[curX][curY] = '>';
					break;
					
				case 'S':
					int idx = 1;
					while (true) {
						int sX = curX + p.xDir * (idx);
						int sY = curY + p.yDir * (idx++);
						if (sX >= 0 && sX < h && sY >= 0 && sY < w) {
							if (map[sX][sY] == '*') {
								map[sX][sY] = '.';
								break;
							} else if (map[sX][sY] == '#') {
								break;
							}
						} else
							break;
					}
					break;
				} // end switch
			} // end for

			System.out.print("#" + tc + " ");
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			
		} // end tc for

	} // end main

}
