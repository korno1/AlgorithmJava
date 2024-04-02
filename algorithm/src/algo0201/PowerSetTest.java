package algo0201;

import java.util.Scanner;

// N개의 원소를 입력받아 가능한 모든 부분집합 생성
// 1<= N <= 10
public class PowerSetTest {
	static int N, input[];
	static boolean isSelected[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		isSelected = new boolean[N];
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		generateSubSet(0);
		
		System.out.println(sb.toString());
	}

	static void generateSubSet(int cnt) {
		if(cnt == N) {
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					sb.append(input[i] + " ");
				}
			}
			sb.append('\n');
			return ;
		}
		
		isSelected[cnt] = true;
		generateSubSet(cnt+1);
		isSelected[cnt] = false;
		generateSubSet(cnt+1);
	}
}
