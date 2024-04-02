package algo0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 
 * 19916KB | 118ms
 */
public class Solution_2806_NQueen_이재민 {

	static int res;
	static int N;
	static int[] col;
	static boolean check(int r) {
		for(int i=0; i<r; i++) {
			if(col[i] == col[r]) return false;
		
			if(Math.abs(r - i) == Math.abs(col[r] - col[i])) {
				return false;
			}
		}
		
		return true;
	}
	
	static void Queen(int cnt) {
		if(cnt == N) {
			res++;
			return ;
		}
		
		for(int i=0; i<N; i++) {
			col[cnt] = i;
			if(!check(cnt)) continue;
			Queen(cnt+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			col = new int[N];
			res = 0;
			
			Queen(0);
			sb.append("#" + tc + " " + res).append('\n');
//			System.out.println(res);
		}
		System.out.println(sb.toString());
	}

}
