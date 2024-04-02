package algo0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 모든 랜선을 활용해야 한다는 조건이 없으니
 * 처음에 최대값을 end로 넣음
 * 23664KB | 484ms
 */
public class Main_B_1654_랜선자르기_이재민 {

	static long[] arr;
	static long N, K;
	static long res;
	
	public static void lan(long start, long end) {
		if(start > end) {
			return ;
		}
		
		long mid = (start + end) / 2;
		long sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			sum += arr[i] / mid;
		}
		
		if(sum >= N) {
			res = mid;
			lan(mid+1, end);
		}
		
		else lan(start, mid-1);
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		K = Long.parseLong(st.nextToken());
		N = Long.parseLong(st.nextToken());
		
		arr = new long[(int) N];
		long max = 0;
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Long.parseLong(st.nextToken());
			if(arr[i] > max) max = arr[i];
		}
		
		lan(1, max);
		
		System.out.println(res);
	}

}
