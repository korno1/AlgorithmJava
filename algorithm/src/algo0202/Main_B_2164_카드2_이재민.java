package algo0202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/*
 * 큐를 사용하여 규칙에 맞게 적용
 * 23772KB | 124ms
 */
public class Main_B_2164_카드2_이재민 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new ArrayDeque<>();
		
		for(int i=1; i<=n; i++) {
			q.add(i);
		}
		
		while(q.size()!=1) {
			q.remove();
			q.add(q.poll());
		}
		
		System.out.println(q.poll());
	}

}
