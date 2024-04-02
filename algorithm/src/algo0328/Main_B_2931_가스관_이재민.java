package algo0328;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 모든 빈칸에 파이프를 전부 다 놔보기
 * 완전탐색
 * 13588KB | 108ms
 */
public class Main_B_2931_가스관_이재민 {
	static int R, C;
	static char[][] map;
	static int mx, my, rx, ry;
	static List<Loc> loc;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static int dir;
	static boolean check;
	static char[] pipe = { '|', '-', '+', '1', '2', '3', '4' };

	static class Loc {
		int x, y;

		public Loc(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static boolean rangeCheck(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}

	static void move(int x, int y, int r, int c, int p) {

		
		if (map[x][y] == '1') {
			if (dir == 2)
				dir = 1;
			else if (dir == 0)
				dir = 3;
		} else if (map[x][y] == '2') {
			if (dir == 1)
				dir = 3;
			else if (dir == 2)
				dir = 0;
		} else if (map[x][y] == '3') {
			if (dir == 1)
				dir = 2;
			else if (dir == 3)
				dir = 0;
		} else if (map[x][y] == '4') {
			if (dir == 3)
				dir = 1;
			else if (dir == 0)
				dir = 2;
		}

		int nx = x + dx[dir];
		int ny = y + dy[dir];
		if(!rangeCheck(nx, ny)) return ;
		if(map[nx][ny] == '.') return;
		
		boolean moveCheck = false;
		
		if (map[nx][ny] == 'Z') {
			System.out.println((r+1) + " " + (c+1) + " " + pipe[p]);
			System.exit(0);
		}

		
		else if (map[nx][ny] == '|') {
			if (dir == 0 || dir == 1)
				moveCheck = true;
		} else if (map[nx][ny] == '-') {
			if (dir == 2 || dir == 3) {
				moveCheck = true;
			}
		} else if (map[nx][ny] == '+') {
			moveCheck = true;
		} else if (map[nx][ny] == '1') {
			if (dir == 0 || dir == 2) {
				moveCheck = true;
			}
		} else if (map[nx][ny] == '2') {
			if (dir == 1 || dir == 2) {
				moveCheck = true;
			}
		} else if (map[nx][ny] == '3') {
			if (dir == 1 || dir == 3) {
				moveCheck = true;
			}
		} else if (map[nx][ny] == '4') {
			if (dir == 3 || dir == 0) {
				moveCheck = true;
			}
		}
		if (moveCheck) {
			move(nx, ny, r, c, p);
		}
	}

	static void stealPipe() {
		int primitiveDir = dir;
		for (int i = 0; i < loc.size(); i++) {
			for (int j = 0; j < 7; j++) {
				dir = primitiveDir;
				map[loc.get(i).x][loc.get(i).y] = pipe[j];
				move(mx, my, loc.get(i).x, loc.get(i).y, j);
				map[loc.get(i).x][loc.get(i).y] = '.';
			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		loc = new ArrayList<>();

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'M') {
					mx = i;
					my = j;
				} else if (map[i][j] == '.')
					loc.add(new Loc(i, j));
			}
		}

		for (int i = 0; i < 4; i++) {
			int nx = mx + dx[i];
			int ny = my + dy[i];
			if (!rangeCheck(nx, ny))
				continue;
			if (map[nx][ny] == '.' || map[nx][ny] == 'Z')
				continue;
			dir = i;
			mx = nx;
			my = ny;
			break;
		}
		stealPipe();

	}
}
