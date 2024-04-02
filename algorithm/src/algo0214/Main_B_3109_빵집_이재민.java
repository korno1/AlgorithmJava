package algo0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 지도의 범위를 넘어가거나 map이 .이 아니면은 탐색을 하지 않는다
 * 첫 열 시작 행마다 번호를 부여해서 .을 번호로 만들어서 방문 처리
 * .xx.0
   .0x01
   .101.
   .21x.
   .32x.
   
   arrival이라는 boolean 배열을 하나 만들어 위에서 붙였던 번호를 인덱스로 이용해
    도착했다는 처리를 해주고 도착했으면 그 번호는 더이상 dfs를 수행하지 않음
    36972KB | 336ms
 */
public class Main_B_3109_빵집_이재민 {
	
	static boolean[] arrival; // 도착 정보
	static char[][] map;
	static int[] dx = {-1, 0, 1};
	static int[] dy = {1, 1, 1};
	
	static int R, C;
	static int res; // 결과값
	
	public static boolean rangeCheck(int r, int c) {
		if(r < 0 || r >= R) return false;
		if(map[r][c] != '.') return false;
		return true;
	}
	
	public static void dfs(int r, int c, int idx) {
		
		// 마지막 열이면 결과값 갱신하고 도착정보 담기
		if(c == C-1) {
			res++;
			arrival[idx] = true;
			return ;
		}
		
		for(int i=0; i<3; i++) {
			int nr = r + dx[i];
			int nc = c + dy[i];
			//범위가 벗어나지 않고 .이고 도착하지 않았으면 수행
			if(rangeCheck(nr, nc) && !arrival[idx]) {
				map[nr][nc] = (char) (idx + '0');
				dfs(nr, nc, idx);
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		arrival = new boolean[R];
		for(int i=0; i<R; i++) {
			String line = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		for(int i=0; i<R; i++) {
			dfs(i, 0, i);
		}
		
		System.out.println(res);
		
	}
}
