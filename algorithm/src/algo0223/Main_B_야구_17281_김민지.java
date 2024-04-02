package algo0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B_야구_17281_김민지 {
	static int N, answer, tempAnswer;
	static int[][] eachGame; // 각 이닝마다 각 선수가 낼 수 있는 결과
	static boolean[] isSelected;
	static int[] selected;
	static int[] order;
	static BaseBall b;
	static Queue<Integer> q;

	static class BaseBall {
		int first, second, third, out, state; // 1루, 2루, 3루, 아웃수, 현재 타자
		
		// 그냥 static 전역 변수로 만들어도 상관 없음
		boolean base[];

		BaseBall(int first, int second, int third, int out, int state) {
			this.first = first;
			this.second = second;
			this.third = third;
			this.out = out;
			this.state = state;
			
			// 선언과 같이 새로 만든 bool 배열
			// 이것도 이닝마다 새로 만들어 줘야함
			base = new boolean[4];
		}
	}

	static void setScore(int score) { // 점수내기
		// 마지막 베이스부터 빼야함 (베이스 갱신을 위해서)
		// 베이스에 있는 사람부터 체크하기 위해 i>0까지
		for(int i=3; i>0; i--) {
			// 만약 베이스가 true면
			if(b.base[i]) {
				// 만약 현재 베이스 번호 + score가 3보다 크면 (베이스 3에서 한번 더 가면 4 즉, 홈으로 들어감)
				if(i + score > 3) {
					// 베이스는 비었다고 체크하고 답 ++;
					b.base[i] = false;
					tempAnswer++;
				}
				// 만약 작으면
				else {
					// 현재 base는 없다고 체크
					b.base[i] = false;
					// 이후 넘어간 베이스에 있다고 체크
					b.base[i + score] = true;
				}
			}
		}
		
		// 타자석에 있는 사람을 기준으로 갱신한 것
		// 홈런 치면 바로 ++
		// 홈런이 아니면 치고 이동하는 곳에 score
		if(score == 4) tempAnswer++;
		else {
			b.base[score] = true;
		}
	}

	static void setOrder(int count) { // count : 몇번째 게임인지
		// selected된 걸 가지고 명령을 새롭게 만듦
		order[3] = eachGame[count][0];
		int idx = 0;
		for (int i = 0; i < 9; i++) {
			if (i == 3)
				continue; // 첫번째 선수 위치는 4번째로 정해졌으니까.
			order[i] = eachGame[count][selected[idx++]];
		}

		while (b.out < 3) { // 아웃의 수가 3보다 작을 때 계속 돌아, 이닝 안끝남.
			int hit = b.state;
			if (order[hit] == 0)
				b.out++; // 0이면 out 개수 증가
			else {
				setScore(order[hit]);
			}


			b.state++;
			if (b.state > 8)
				b.state = 0;
		}
	}

	static void permutation(int cnt) {
		if (cnt == 8) {
//			System.out.println(Arrays.toString(selected)); // 순열 생성 완료.
			// 이 순서의 선수들로 N게임 진행해야함.
			b = new BaseBall(0, 0, 0, 0, 0); // state는 selected[0]
			for (int i = 0; i < N; i++) {
				q = new ArrayDeque<>();
				setOrder(i);
				b.first = 0;
				b.second = 0;
				b.third = 0;
				b.out = 0;
				// 이닝마다 새로 만들어 줘야함
				b.base = new boolean[4];
			}
			answer = Math.max(answer, tempAnswer);
			tempAnswer = 0;
			return;
		}

		for (int i = 1; i <= 8; i++) {
			if (isSelected[i - 1])
				continue;
			selected[cnt] = i;
			isSelected[i - 1] = true;
			permutation(cnt + 1);
			isSelected[i - 1] = false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		eachGame = new int[N][9];
		order = new int[9];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				eachGame[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 첫번째 선수는 4번째로 위치가 고정이기 때문에, 빼고 8개로 만들어줌.
		isSelected = new boolean[8];
		selected = new int[8];
		permutation(0);
		System.out.println(answer);
	}

}
