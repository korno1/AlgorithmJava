package algo0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 현재 1인 지점에서 가장 큰 종이를 붙였다고 해서 그게 최소값이 아닐 수 있음
 * 모든 경우의 수를 다 생각해줘야하기 하기 때문에 백트래킹 사용
 * 23464KB | 244ms 
 */

public class Main_B_17136_색종이붙이기_이재민 {

	static int[][] map;
	static int N = 10;
	static int[] colorPaper = {5, 5, 5, 5, 5};
	static int res = Integer.MAX_VALUE;
	
	// 색종이를 붙일 수 있는지
	static boolean attachCheck(int x, int y, int size) {
		
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(map[i][j] != 1) return false;
			}
		}
		
		return true;
	}
	
	// 색종이 붙이기
	static void attach(int x, int y, int size) {
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				//색종이 붙임
				map[i][j] = -1;
			}
		}
	}
	
	// 색종이 떼기
	static void detach(int x, int y, int size) {
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				//색종이 붙임
				map[i][j] = 1;
			}
		}
	}
	
	static void dfs(int x, int y, int cnt, int paper) {
		if(res < paper) return;
		
		if(cnt == 100) {
			res = Math.min(res, paper);
			return;
		}
		
		if(x==N) return;
		
		if(y==N) {
			dfs(x+1, 0, cnt, paper);
			return;
		}
		
		if(map[x][y] == 1) {
			for(int i=0; i<5; i++) {
				if((x+i+1 <= N) && (y+i+1 <= N) && attachCheck(x, y, i+1) && colorPaper[i] > 0) {
					colorPaper[i]--;
					attach(x, y, i+1);
					dfs(x, y+1, cnt+1, paper+1);
					colorPaper[i]++;
					detach(x, y, i+1);
				}
			}
		}
		else {
			dfs(x, y+1, cnt+1, paper);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		dfs(0, 0, 0, 0);
		
		System.out.println(res==Integer.MAX_VALUE ? -1 : res);
		
		

	}

}
