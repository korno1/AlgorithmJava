package algo0227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/*
 * 큐에 넣고 레벨별로 돌리기
 * 3가지 연산을 할 때 1이 안만들어지는 경우는 없음
 * 12524KB | 80ms
 */

public class Main_B_1463_1로만들기_이재민 {

	static int N;
	static int cnt;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		visited = new boolean[N+1];
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		q.add(N);
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0; i<size; i++) {
				int x = q.poll();
				
				if(x == 1) {
					System.out.println(cnt);
					return;
				}
				
				
				if(x%3==0 && !visited[x/3]) {
					visited[x/3] = true;
					q.add(x/3);
				}
				
				if(x%2==0 && !visited[x/2]) {
					visited[x/2] = true;
					q.add(x/2);
				}
				
				if(x-1 >= 1 && !visited[x-1]) {
					visited[x-1] = true;
					q.add(x-1);
				}
				
			}
			
			cnt++;
		}
		
		System.out.println(cnt);
	}

}
