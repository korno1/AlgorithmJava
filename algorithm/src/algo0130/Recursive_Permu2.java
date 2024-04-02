package algo0130;

import java.util.Arrays;
import java.util.Scanner;

public class Recursive_Permu2 {

	// N P R
	static int N; // arr의 크기
	static int R; // 뽑을 개수
	static int id = 1;
	static int[] arr;
	static boolean[] isSelected;
	static int[] picked;


	static void permu(int idx) {
		if(idx == R) {
			System.out.println(id++ + " " + Arrays.toString(picked));
			return ;
		}
		
		for(int i=0; i<N; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			picked[idx] = arr[i]; 
			permu(idx+1);
			isSelected[i] = false;
		}
	}
	
	// 5 3
	// 7 8 9 10 11
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		R = sc.nextInt();
		arr = new int[N];
		picked = new int[R];
		isSelected = new boolean[N + 1];

		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		permu(0);

//		permutation(0, new boolean[N+1], new int[R]);

	}

}
