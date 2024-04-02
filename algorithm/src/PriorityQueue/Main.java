package PriorityQueue;

import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
//		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // 내림차순
		pq.add(10);
		pq.add(30);
		pq.add(15);
		pq.add(-40);
		
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}

}
