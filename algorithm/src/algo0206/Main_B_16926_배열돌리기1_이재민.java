package algo0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 처음 값을 temp에 저장 후 당기기 사용
 * 이후 반복문을 끝내는 조건문에서 temp를 넣어줌
 * 41800KB | 1548ms
 */

public class Main_B_16926_배열돌리기1_이재민 {

	static int n, m, r;
	// 우 하 좌 상
	public static int d[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	public static boolean rangeCheck(int x, int y, int i) {
		if(x < i || x >= n-i) return false;
		if(y < i || y >= m-i) return false;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		int[][] res = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		long bt = System.currentTimeMillis();
		for(int i=0; i<Math.min(n, m)/2; i++) {
			for(int j=0; j<r; j++) {
				int temp = map[i][i];
				int dir = 0;
				int x = i;
				int y = i;
				while(true) {
					if(!rangeCheck(x + d[dir][0], y + d[dir][1], i)) {
						dir++;
					}
					if(x==i+1 && y==i) {
						map[x][y] = temp;
						break;
					}
					// 상단
					if(dir == 0) {
						map[x][y] = map[x][y+1];
					}
					// 오른쪽
					else if(dir == 1) {
						map[x][y] = map[x+1][y];
					}
					// 하단
					else if(dir==2) {
						map[x][y] = map[x][y-1];
					}
					
					// 왼쪽
					else if(dir==3){
						map[x][y] = map[x-1][y];
					}
					
					x += d[dir][0];
					y += d[dir][1];
				}
			}
		} // end for
		long at = System.currentTimeMillis();
		long sdt = (at - bt);
		System.out.println(sdt);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
		
	}

}
