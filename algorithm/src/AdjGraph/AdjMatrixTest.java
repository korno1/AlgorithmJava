package AdjGraph;

import java.util.Arrays;
import java.util.Scanner;

public class AdjMatrixTest {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		int[][] adjMatrix = new int[V][V];
		for(int i=0; i<E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[to][from] = adjMatrix[from][to] = 1; // 무방향
		}
		
		for(int[] row : adjMatrix) {
			System.out.println(Arrays.toString(row));
		}
	}

}
