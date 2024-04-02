package algo0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 삼항연산자 이용 절대값이 같으면 a-b로 정렬 아니면 절대값 a - 절대값 b
 * 28388KB | 416ms
 */
public class Main_B_11286_절댓값힙_이재민 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> Math.abs(a)==Math.abs(b)? a-b : Math.abs(a)-Math.abs(b));
		
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x==0) {
				if(q.isEmpty()) sb.append(0).append('\n');
				else sb.append(q.poll()).append('\n');
			}
			else q.add(x);
			
		}
		
		System.out.println(sb.toString());
	}

}
