package algo0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 스택에 담겨있는 자료 중 현재 탐색하고 있는 인덱스의 값보다 작으면 전부 pop
 * stack -> 9 5 4가 있고 arr[i]가 7이라면 while문을 돌려 5와 4를 pop
 * 만약 반복문을 수행하고 스택이 남아있다면 레이저 신호를 수신할 수 있는 탑이 있다는 것
 * 그리고 현재 인덱스의 값을 스택에 add
 */

public class Main_BJ_2493_탑_이재민 {

	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		Stack<Pair> stk = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			int input = Integer.parseInt(st.nextToken());
			
			while (!stk.isEmpty() && stk.peek().x < input) stk.pop();
			
			sb.append(!stk.isEmpty() ? stk.peek().y : 0).append(' ');
			
			stk.add(new Pair(input, i));
		}

		System.out.println(sb.toString());

	}

}
