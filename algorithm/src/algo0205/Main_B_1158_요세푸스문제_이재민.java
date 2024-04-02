package algo0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 큐는 FIFO라 원형을 유지 할 수 있음
 * K-1번째 만큼 앞에를 뒤에 넣고 K번째는 제거한 후 빌더에 append
 * 15476KB | 224ms
 */

public class Main_B_1158_요세푸스문제_이재민 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		for(int i=1; i<=n; i++) {
			q.add(i);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(!q.isEmpty()) {
			for(int i=0; i<k-1; i++) q.add(q.poll());
			sb.append(q.size()==1 ? q.poll() : q.poll() + ", ");
		}
		
		sb.append(">");
		System.out.println(sb.toString());
	}
}
