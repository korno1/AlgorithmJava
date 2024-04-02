package algo0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 적록색약이 아닌 사람과 적록색약인 사람을 나누어서 배열을 만들고
 * 입력 받을때 적록색약인 사람은 G 색깔은 R색깔로 바꾸어서 넣어준다
 * 그리고 따로따로 dfs 함수를 만들어서 호출
 * 12200KB | 92ms
 */

public class Main_B_10026_적록색약_이재민_DFS {
	static int N, res;
	static char[][] yesColor, noColor;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static boolean rangeCheck(int x, int y) {
		return x>=0 && x<N && y>=0 && y<N;
	}
	
	// 적록색약 아님
	static void ydfs(int x, int y, char target) {
		yesColor[x][y] = '0';
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(!rangeCheck(nx, ny)) continue;
			
			if(yesColor[nx][ny] != '0' && yesColor[nx][ny] == target) {
				ydfs(nx, ny, target);
			}
		}
	}
	
	// 적록색약
	
	static void ndfs(int x, int y, char target) {
		noColor[x][y] = '0';
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(!rangeCheck(nx, ny)) continue;
			
			if(noColor[nx][ny] != '0' && noColor[nx][ny] == target) {
				ndfs(nx, ny, target);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		yesColor = new char[N][N];
		noColor = new char[N][N];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<N; j++) {
				yesColor[i][j] = line.charAt(j);
				noColor[i][j] = line.charAt(j) == 'G' ? 'R' : line.charAt(j);
			}
		}
		
		// 적록색약이 아닌 사람
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(yesColor[i][j] != '0') {
					ydfs(i, j, yesColor[i][j]);
					res++;
				}
			}
		}
		System.out.print(res + " ");
		res = 0;
		// 적록색약
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(noColor[i][j] != '0') {
					ndfs(i, j, noColor[i][j]);
					res++;
				}
			}
		}
		System.out.println(res);
		
	}

}
