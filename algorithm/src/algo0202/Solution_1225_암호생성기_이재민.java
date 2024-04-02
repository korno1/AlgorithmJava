package algo0202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 큐를 이용한 문제풀이
 * 21392KB | 124ms
 */

public class Solution_1225_암호생성기_이재민 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc<=10; tc++) {
			Queue<Integer> q = new ArrayDeque<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<8; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			
			int idx = 1;
			
			// idx를 만들어서 5가 넘으면 사이클 초기화
			while(!(q.peek()-idx <= 0)) {
				q.add(q.poll() - idx);
				
				idx++;
				if(idx>5) idx = 1;
			}
			
			// 반복문 조건에 의해서 마지막에 poll과 add 수행
			q.poll();
			q.add(0);
		
			StringBuilder sb = new StringBuilder();
			while(!q.isEmpty())
				sb.append(q.poll() + " ");
			System.out.println("#" + tc + " " + sb.toString());
		}
	}

}
