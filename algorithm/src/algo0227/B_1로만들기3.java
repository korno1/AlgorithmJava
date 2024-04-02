package algo0227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/*
 * 큐에 넣고 레벨별로 돌리기
 * 3가지 연산을 할 때 1이 안만들어지는 경우는 없음
 * 12524KB | 80ms
 */

public class B_1로만들기3 {

	static Long N;
	static Long cnt;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Long.parseLong(br.readLine());
		
		Queue<Long> q = new ArrayDeque<>();
		Map<Long, Boolean> map = new HashMap<>();
		cnt = 0L;
		q.add((long)N);
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0; i<size; i++) {
				long x = q.poll();
				
				if(x == 1) {
					System.out.println(cnt);
					return;
				}
				
				if(map.containsKey(x)) continue;
				
				map.put(x, true);
				
				if(x%3==0) {
					q.add(x/3);
				}
				
				if(x%2==0) {
					q.add(x/2);
				}
				
				if(x-1 >= 1) {
					q.add(x-1);
				}
				
			}
			
			cnt++;
		}
		
		System.out.println(cnt);
	}

}
