package algo0130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_15649_N과_M1_이재민 {

	static int n;
	static int m;
	static int[] picked;
	static boolean[] visited;
	static void permu(int cnt) {
		if(cnt == m) {
			for(int i=0; i<cnt; i++) {
				System.out.print(picked[i] + " ");
			}
			System.out.println();
			return ;
		}
		
		for(int i=1; i<=n; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			picked[cnt] = i;
			permu(cnt+1);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		picked = new int[m];
		visited = new boolean[n+1];
		
		permu(0);
	}

}
