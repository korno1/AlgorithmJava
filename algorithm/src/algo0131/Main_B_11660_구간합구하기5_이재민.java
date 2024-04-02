package algo0131;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * 입력 받을때 입력받은 자리의 값과 이전에 i-1의 누적합과 j-1의 누적합을 더하고
 * 공통으로 더해진 (2번 더해진)부분을 뺌
 * 
 * 결과를 도출할 때 작은 인덱스의 i-1, 큰인덱스의 j 부분과
 * 작은 인덱스의 j-1 큰 인덱스의 i부분을 빼고 공통으로 빠진 부분을 더한 뒤 출력
 * 136184KB | 2028ms
 */

public class Main_B_11660_구간합구하기5_이재민 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n+1][n+1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				// 현재 인덱스 이전에 누적했던 부분을 더해주고 공통부분 빼주기
				arr[i][j] += arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
			}
		}
		
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			// x2 y2의 누적합 즉 0,0에서 x2,y2 구간의 누적합에서
			// 원하는 구간을 제외한 누적합을 빼주고 공통 부분을 더해줌
			int sum = arr[x2][y2] - arr[x1-1][y2] - arr[x2][y1-1] + arr[x1-1][y1-1];
			System.out.println(sum);
		}
		


	}

}
