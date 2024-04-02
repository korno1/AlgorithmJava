package NextPermutation;

import java.util.Arrays;
import java.util.Scanner;

public class NPTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] input = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		int selected[] = {0, 0, 1, 1, 1};
		Arrays.sort(input);
		// 순열
		do {
//			System.out.println(Arrays.toString(input));
		}while(np(input));
		
		// 조합
		do {
//			System.out.println(Arrays.toString(input));
			for(int i=0; i<N; i++) {
				if(selected[i] == 1) {
					System.out.print(input[i] + " ");
				}
			}
			System.out.println();
		}while(np(selected));
	}

	public static boolean np(int[] p) { // p : 현 순열
		int N = p.length;
		// 교환위치 찾기 (뒤쪽부터 꼭대기 찾으면 꼭대기 이전이 교환위치)
		int i = N - 1;
		while (i > 0 && p[i - 1] >= p[i])
			--i;

		if (i == 0)
			return false; // 현 순열의 상태가 가장 큰 순열

		// 교환 위치 (i-1)에 넣을 값 뒤쪽부터 찾기(큰 값 중 최소값)
		int j = N - 1;
		while(p[i-1] >= p[j]) --j;
		
		// 교환위치(i-1) 값과 찾은위치(j)값 교환
		swap(p, i-1, j);
		
		// 꼭대기(i) 위치부터 맨 뒤까지 오름차순 정렬
		int k = N-1;
		while(i<k) swap(p, i++, k--);
		
		return true;
	
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr [i] = arr[j];
		arr[j] = temp;
	}

}
