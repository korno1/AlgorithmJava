package algo0131;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 값을 누적시켜서 배열에 저장
 * 이후 x y가 받아지면 arr[y] - arr[x]
 * 65960KB | 1932ms
 */

public class Main_BJ_11659_구간합구하기4_이재민 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 입력 index는 1부터이기 때문에 n+1
		int[] arr = new int[n+1];
		
		
		st = new StringTokenizer(br.readLine());
		// 입력 받을 때 누적합
		for(int i=1; i<=n; i++) {
			arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
		}
		
		// 2에서 4까지 더하는거면 arr[4] - arr[1]
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			System.out.println(arr[y] - arr[x-1]);
		}
	}

}
