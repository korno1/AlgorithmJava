package algo0131;

import java.util.Arrays;
import java.util.Scanner;

public class DiceTest {

	static int N, numbers[];
	static boolean[] isSelected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];

		int mode = sc.nextInt();

		switch (mode) {
		case 1: // 중복 순열
			dice1(0);
			break;

		case 2: // 순열
			isSelected = new boolean[7]; // 주사위 중복 방지
			dice2(0);
			break;
		
		case 3: // 중복 조합
			dice3(0, 1);
			break;
		
		case 4: // 조합
			dice4(0, 1);
			break;
		}
		
		sc.close();
	}

	// 중복 허용
	static void dice1(int cnt) { // 주사위 던지기

		if (cnt == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = 1; i <= 6; i++) { // 모든 주사위를 눈의 수를 시도
			numbers[cnt] = i;
			dice1(cnt + 1);
		}
	}

	static void dice2(int cnt) { // 주사위 던지기

		if (cnt == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = 1; i <= 6; i++) { // 모든 주사위를 눈의 수를 시도
			if (isSelected[i])
				continue;

			numbers[cnt] = i;
			isSelected[i] = true;
			dice2(cnt + 1);
			isSelected[i] = false;
		}
	}

	// 중복 조합
	static void dice3(int cnt, int start) {
		if(cnt == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		// 시작점부터 가능한 끝까지 선택하는 시도
		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice4(cnt+1, i);
		}
	}
	// 조합
	static void dice4(int cnt, int start) {
		if(cnt == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		// 시작점부터 가능한 끝까지 선택하는 시도
		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice4(cnt+1, i+1);
		}
	}
}
