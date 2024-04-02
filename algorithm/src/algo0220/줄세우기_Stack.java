package algo0220;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class 줄세우기_Stack {
	
	static int N, M;
	static List<Integer>[] list;
	static boolean[] visited, input;
	static List<Integer> stk;
	
	static void dfs(int x) {
		
		visited[x] = true;
		
		for(int nx : list[x]) {
			if(!visited[nx]) {
				dfs(nx);
			}
		}
		
		stk.add(x);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
	
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		input = new boolean[N+1];
		stk = new ArrayList<Integer>();
		
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list[x].add(y);
//			input[y] = true;
		}
		
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				dfs(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=stk.size()-1; i>=0; i--) {
			sb.append(stk.get(i) + " ");
//			System.out.print(stk.pop() + " ");
		}
		System.out.println(sb);
	}
}