package NextPermutation;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		int N = 5;
		int R = 3;
		
		int[] values = {3, 5, 7, 9, 11};
		
		int[] selected = {0, 0, 1, 1, 1};
		
		
		do {
			System.out.println(Arrays.toString(selected));
			
			for(int i=0; i<N; i++) {
				if(selected[i] == 1) {
					System.out.print(values[i] +" ");
				}
			}
			System.out.println();
			
		} while (np(selected));
		
		
		
	}
	//54321
	private static boolean np(int[] arr) {
		int N = arr.length;
//		1. 뒤에서부터 연속하는 두자리 수( i-1, i ), 오른쪽이 큰 경우 탐색
//	      arr[i-1] = 4
//	      arr[i] = 7
		int i=N-1;
		while( i>0 && arr[i-1] >= arr[i] ) i--;
		
		if(i==0) return false;	//현재 배열이 만들 수 있는 가장 큰 순열
		

//	2. 뒤에서부터  arr[i-1] 요소와 비교했을 때, arr[i-1] 요소보다 큰 값과 swap
//	1567432
		int j=N-1;
		while( arr[i-1] >= arr[j] ) j--;
		
		swap(i-1, j, arr);
		
		
//	3. i번째 요소부터 나머지 숫자를 오름차순 정렬
//		=> 앞 뒤 요소 스왑하는 게 가장 빠른 방법
//           i	k		
//		156  7432
//      	  ik		
//		156  7432
//			  ki
		      
		int k = N-1;
		while(i < k) swap(i++, k--, arr);
		
		return true;
	}
	private static void swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
