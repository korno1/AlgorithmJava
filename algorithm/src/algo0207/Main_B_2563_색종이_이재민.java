package algo0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * boolean 배열로 한번 색종이가 있는 부분은 true처리
 * bool 배열이 false면 sum을 하나 더해주고 true면 아무 처리 안함
 * 11572KB | 88ms
 */
public class Main_B_2563_색종이_이재민 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		boolean[][] check = new boolean[100][100];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int j=x; j<x+10; j++) {
				for(int k=y; k<y+10; k++) {
					if(!check[j][k]) {
						sum++;
						check[j][k] = true;
					}
				}
			}
		}
		
		System.out.println(sum);
	}

}
