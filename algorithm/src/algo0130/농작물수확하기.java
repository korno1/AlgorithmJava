package algo0130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 농작물수확하기 {
	static int res;
	static char[][] arr;
	static int n;
	
	public static void up(int x, int y, int l) {
		if(x<0) return ;
		res += arr[x][y] - '0';
		left(x, y-1, 1, l);
		right(x, y+1, 1, l);
		up(x-1, y, l-1);
	}
	
	public static void down(int x, int y, int l) {
		if(x>=n) return ;
		res += arr[x][y] - '0';
		left(x, y-1, 1, l);
		right(x, y+1, 1, l);
		down(x+1, y, l-1);
	}
	
	public static void left(int x, int y, int cnt, int l) {
		if(cnt>l) return ;
		res += arr[x][y] - '0';
		left(x, y-1, cnt+1, l);
	}
	
	public static void right(int x, int y, int cnt, int l) {
		if(cnt>l) return ;
		res += arr[x][y] - '0';
		right(x, y+1, cnt+1, l);
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			arr = new char[n][n];
			res = 0;
			for(int i=0; i<n; i++) {
				String line = br.readLine();
				for(int j=0; j<n; j++) {
					arr[i][j] = line.charAt(j);
				}
			}
			
			int x = n/2;
			int y = n/2;
			res += arr[x][y] - '0';
			left(x, y-1, 1, n/2);
			right(x, y+1, 1, n/2);
			up(x-1, y, n/2-1);
			down(x+1, y, n/2-1);
			System.out.println("#" + tc + " " + res);
		}
	}

}
