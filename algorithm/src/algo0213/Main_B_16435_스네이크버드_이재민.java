package algo0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 과일의 높이를 오름차순 정렬 후 스네이크 버드가
 * 스네이크 버드가 먹을 수 있는 과일인지 판단
 * 11964KB | 88ms
 */

public class Main_B_16435_스네이크버드_이재민 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
	
		int[] fruits = new int[N];
		
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			fruits[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(fruits);
		
		for(int i=0; i<N; i++) {
			if(L >= fruits[i]) L++;
			else break;
		}
		System.out.println(L);
	}

}
