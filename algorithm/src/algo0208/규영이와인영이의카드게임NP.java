package algo0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 규영이와인영이의카드게임NP {
	static int[] 규영card, 인영card;
	static int N = 9;
	static int 규영win, 인영win;
	
	static void swap(int i, int j) {
		int temp = 인영card[i];
		인영card[i] = 인영card[j];
		인영card[j] = temp;
	}
	static boolean NP() {
		int size = N-1;
		int i = size;
		while(i > 0 && 인영card[i-1] >= 인영card[i]) {
			i--;
		}
		
		if(i==0) return false;
		
		int j = size;
		while(인영card[j] <= 인영card[i-1]) {
			j--;
		}
		
		swap(i-1, j);
		
		
		while(i < size) swap(i++, size--);
		
		return true;
	}
	
	public static void game() {
		int 규영score = 0;
		int 인영score = 0;
		
		for(int i=0; i<9; i++) {
			if(규영card[i] > 인영card[i]) 규영score += 규영card[i] - 인영card[i];
			else 인영score += 인영card[i] - 규영card[i];
		}
		
		if(규영score > 인영score) 규영win++;
		else if(규영score < 인영score) 인영win++;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=t; tc++) {
		
			규영card = new int[9];
			인영card = new int[9];
			규영win = 0;
			인영win = 0;
			boolean check[] = new boolean[19];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<9; i++) {
				규영card[i] = Integer.parseInt(st.nextToken());
				check[규영card[i]] = true;
			}
			int cnt = 0;
			for(int i=1; i<=18; i++) {
				if(!check[i]) 인영card[cnt++] = i; 
			}
			
			do {
				game();
			}while(NP());
			
			sb.append("#" + tc + " " + 규영win + " " + 인영win).append('\n');
		}
		System.out.println(sb.toString());
	}

}
