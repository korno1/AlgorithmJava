package algo0131;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 전체 난쟁이의 키를 sum에 더하고
 * 오름차순 출력을 위해 난쟁이 키가 담긴 배열 오름차순 정렬
 * 9명중 2명을 뽑아 전체 키에서 빼고
 * sum이 100이면 난쟁이 출력하고 시스템 종료
 * 18888KB | 236ms
 */

public class Main_B_2309_일곱난쟁이_이재민 {
	
	static int sum;
	static int[] arr; // 난쟁이들의 키
	static int[] c; // 조합을 담기 위한 배열
	static void combi(int cnt, int idx) {
		if(cnt == 2) {
			int x = c[0];
			int y = c[1];
			if(sum - x - y == 100) {
				Arrays.stream(arr).forEach(a -> {
					if(a != x && a != y) {
						System.out.println(a);
					}
				});
				System.exit(0);
			}
			return ;
			
		}
		
		for(int i=idx; i<9; i++) {
			c[cnt] = arr[i];
			combi(cnt+1, i+1);
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		arr = new int[9];
		c = new int[2];
		
		for(int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}
		Arrays.sort(arr);
		combi(0, 0);
	}

}
