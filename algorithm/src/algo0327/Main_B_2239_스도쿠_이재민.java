package algo0327;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * 리스트에 0인 값을 저장해 놓음
 * 처음에는 0인 지점에 for문을 1부터 9까지 돌려서 넣어주는 방식으로 생각했지만
 * 예제에서 2,0에 6이 들어가면 2,2에 6이 들어갈 수 없으므로 백트래킹으로 수행
 * 14820KB | 340ms
 */

public class Main_B_2239_스도쿠_이재민 {

	static int[][] map;
	static int N;
	static List<Loc> zero;
	static boolean[][] row, col, square;

	static class Loc {
		int x, y;

		public Loc(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static boolean check(int x, int y, int i) {
		if (row[x][i])
			return false;
		if (col[y][i])
			return false;
		if (square[x / 3 * 3 + y / 3][i])
			return false;

		return true;
	}

	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	static void sdoku(int idx) {
		if (idx == zero.size()) {
			print();
			System.exit(0);
		}

		int x = zero.get(idx).x;
		int y = zero.get(idx).y;

		for (int i = 1; i <= 9; i++) {
			if (check(x, y, i)) {
				row[x][i] = true;
				col[y][i] = true;
				square[x / 3 * 3 + y / 3][i] = true;
				map[x][y] = i;
				
				sdoku(idx + 1);
				
				row[x][i] = false;
				col[y][i] = false;
				square[x / 3 * 3 + y / 3][i] = false;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = 9;

		map = new int[N][N];
		zero = new ArrayList<>();

		row = new boolean[N][10];
		col = new boolean[N][10];
		square = new boolean[N][10];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
				if (map[i][j] == 0)
					zero.add(new Loc(i, j));
				else {
					row[i][map[i][j]] = true;
					col[j][map[i][j]] = true;
					square[i / 3 * 3 + j / 3][map[i][j]] = true;
				}
			}
		}
		sdoku(0);

	}

}
