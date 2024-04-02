package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
5
0 2 2 5 9
2 0 3 4 8
2 3 0 7 6
5 4 7 0 5
9 8 6 5 0

==> 8

4 
0 94 53 16 
79 0 24 18 
91 80 0 98 
26 51 92 0
==> 16


7
0   2   8   5   9  15  20
2   0   5   4   7  10  16
8   5   0   7   6   4  10
5   4   7   0  15   8   9
9   7   6  15   0  11  13
15 10   4   8  11   0   6
20 16  10   9  13   6   0

==> 14
 */
/**
 * @author taeheekim
 */
public class SD3_Dijkstra_AdjList_PQ {

	static class Node{
		int vertex,weight;
		Node next;
		
		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", weight=" + weight + ", next=" + next + "]";
		}
	}
	private static class Vertex implements Comparable<Vertex>{
		int no;
		int totalDistance;
		
		public Vertex(int no, int totalDistance) {
			this.no = no;
			this.totalDistance = totalDistance;
		}
		@Override
		public int compareTo(Vertex o) {
			return this.totalDistance-o.totalDistance;
		}
		@Override
		public String toString() {
			return "Node [vertex=" + no + ", distance=" + totalDistance + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine().trim());
		int V = Integer.parseInt(st.nextToken()); //정점 갯수
		int E = Integer.parseInt(st.nextToken()); //간선 갯수
		st = new StringTokenizer(in.readLine().trim());
		int start = Integer.parseInt(st.nextToken());;
		
		int end =  Integer.parseInt(st.nextToken());; //도착점 인덱스
		final int INF = Integer.MAX_VALUE;
		
		Node[] adjList = new Node[V];
		int[] distance = new int[V];
		boolean[] visited = new boolean[V];
		
		for(int i=0; i<E; ++i){
			st = new StringTokenizer(in.readLine().trim(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, weight, adjList[from]);
		}
		
		Arrays.fill(distance, INF);
		
		PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>();
		distance[start] = 0;
		pQueue.offer(new Vertex(start, distance[start]));
		
		Vertex current = null;
		while(!pQueue.isEmpty()){
			// a단계 : 출발지에서 가까운 정점을 선택한다.
			current = pQueue.poll();
			if(visited[current.no]) continue;
			
			visited[current.no] = true; // 선택 정점 방문 처리 : 음의 가중치가 없는 상황에서 이 정점까지의 최소비용은 더 줄어들수 없음
			if(current.no == end) break;// 선택 정점이 도착정점이면 탈출.만약,탈출하지 않고 계속 하면 출발지로부터 모든 정점 각각까지 도착하는 최소거리비용이 다 계산됨. 
			
			//b단계: 출발지에서 가까운 current정점을 경유지로 하여 갈수 있는 다른 방문하지 않은 정점들에 대한 처리
			for(Node temp = adjList[current.no]; temp != null; temp=temp.next) {
        		// 해당 정점이 방문 정점이 아닌 경우
            	// 최소거리 정점을 거쳐서 해당 정점을 갈경우의 토탈 가중치와 기존까지 계산된 해당정점까지의 토탈가중치를 비교하여 최소값을 만족하면 갱신
				if(!visited[temp.vertex] &&  // 생략 가능 : 이미처리한 정점의 최소비용은 현재 경유지를 고려한 비용보다 항상 작으므로. 즉,거쳐오면 더 비용 늘어남 
						distance[temp.vertex] > current.totalDistance+temp.weight){
					distance[temp.vertex] = current.totalDistance+temp.weight;
					pQueue.offer(new Vertex(temp.vertex, distance[temp.vertex]));
				}
			}
		}
		System.out.println(distance[end] != INF ? distance[end] : -1);
	}

}
