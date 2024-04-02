package algo0130;

import java.util.Arrays;
import java.util.Scanner;

public class Recursive_Permu {

	// N P R
	static int N; // 1 ~ 5까지의 숫자
	static int R; // 뽑을 개수
	static int idx = 1;

	static int[] picked;
	static boolean[] isSelected;

//	public static void permutation(int cnt, boolean[] visited, int[] arr) {
//		if(cnt == R) {
//			System.out.println(idx++ + " " + Arrays.toString(arr));
//			return ;
//		}
//		
//		for(int i=1; i<=N; i++) {
//			if(!visited[i]) {
//				visited[i] = true;
//				arr[cnt] = i;
//				permutation(cnt+1, visited, arr);
//				visited[i] = false;
//			}
//		}
//	}

	/*
	 * 숫자 한 개를 뽑고 다음 자리의 숫자는 재귀함수 호출로 맡긴다.
	 */
	private static void permu(int idx) {

		if (idx == R) {
			System.out.println(Arrays.toString(picked));
			return;
		}

		for (int i = 1; i <= N; i++) {
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			picked[idx] = i;
			permu(idx + 1);
			isSelected[i] = false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		R = sc.nextInt();

		picked = new int[R];
		isSelected = new boolean[N + 1];

		permu(0);

//		permutation(0, new boolean[N+1], new int[R]);

	}

}
