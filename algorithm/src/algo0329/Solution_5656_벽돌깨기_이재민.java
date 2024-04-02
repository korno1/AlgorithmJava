package algo0329;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 중복순열을 돌려서 쏠 자리를 고름
 * 이후 큐에 1이 넘는 숫자를 가진 벽돌을 큐에 넣어서 연쇄반응 수행
 * 70796KB | 273ms
 */

public class Solution_5656_벽돌깨기_이재민 {
	static int N, W, H;
	static int[][] map, copyMap;
	static int[] picked;
	static int res;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Queue<Loc> q;
	static StringBuilder sb = new StringBuilder();
	static boolean check;
	
	static class Loc {
		int x, y, level;

		public Loc(int x, int y, int level) {
			this.x = x;
			this.y = y;
			this.level = level;
		}

	}

	static boolean rangeCheck(int x, int y) {
		return x >= 0 && x < H && y >= 0 && y < W;
	}

	// 현재 x열에서 제일 높은 위치에 있는 벽돌을 찾는 코드
	static int searchBrick(int x) {
		int h = H;
		for (int i = 0; i < H; i++) {
			// x열에 i행의 값이 0이 아니면 부셔야하는 벽돌이라는 것
			if (copyMap[i][x] != 0) {
				h = i;
				break;
			}
		}
		return h;
	}

	static void shoot(int idx) {
		// 어디 자리에 쏠것인지 정한 중복순열
		int x = picked[idx];
		// x열에 위치한 가장 높은 벽돌 위치 h를 구함

		int h = searchBrick(x);
		if(h == H) return;
		
		// 만약 애초에 처음에 부수려고 하는 벽돌이 1이면 연쇄반응이 일어나지 않음
		if (copyMap[h][x] == 1) {
			copyMap[h][x] = 0;
			return;
		}

		// 큐를 생성하여 연쇄반응을 위한 사방탐색을 시작하는데
		// 만약 사방탐색을 하다가 1이면 바로 0으로 만들어 부수고
		// 1보다 크면 똑같이 0으로 만들어주고 다음 사방탐색을 위하여 연쇄반응 길이를 저장
		q.clear();
		q.add(new Loc(h, x, copyMap[h][x]));

		while (!q.isEmpty()) {
			Loc l = q.poll();
			for (int k = 0; k < l.level; k++) {
				for (int i = 0; i < 4; i++) {
					int nx = l.x + dx[i] * k;
					int ny = l.y + dy[i] * k;
					if (!rangeCheck(nx, ny))
						continue;
					if (copyMap[nx][ny] == 1) {
						copyMap[nx][ny] = 0;
					} else if (copyMap[nx][ny] > 1) {
						q.add(new Loc(nx, ny, copyMap[nx][ny]));
						copyMap[nx][ny] = 0;
					}
				}
			}
		}

	}

	static void fall() {
		// 열을 기준으로 j를 행으로 둬서 현재 열의 가장 밑을 찾아줌 - index
		for (int i = 0; i < W; i++) {
			int index = -1;
			for (int j = H - 1; j >= 0; j--) {
				if (copyMap[j][i] == 0) {
					index = j;
					break;
				}
			}
			if (index == -1)
				return;

			for (int j = index-1; j >= 0; j--) {
				if (copyMap[j][i] != 0) {
					copyMap[index][i] = copyMap[j][i];
					copyMap[j][i] = 0;
					index--;
				}
			}
		}
	}

	// 중복 순열 - 똑같은 자리를 계속 때릴 수 있고
	// 때리는 순서에 따라서 결과에 달라짐
	static void permu(int cnt) {
		if (cnt == N) {
			copyMap = new int[H][W];
			// 매 순열마다 배열을 복사해서 사용
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					copyMap[i][j] = map[i][j];
				}
			}

			// 슈팅을 시작
			for (int i = 0; i < N; i++) {
				shoot(i);
				fall();
			}

			// 벽돌 떨어트림

			//
			int count = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (copyMap[i][j] != 0) {
						count++;
					}
				}
			}
			res = Math.min(count, res);
			return;
		}
		
		for (int i = 0; res!=0 && i < W; i++) {
			
			picked[cnt] = i;
			permu(cnt + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new int[H][W];
			res = Integer.MAX_VALUE;
			picked = new int[N];
			q = new ArrayDeque<>();
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			permu(0);

			sb.append(res).append('\n');
		}
		System.out.println(sb);
	}

}