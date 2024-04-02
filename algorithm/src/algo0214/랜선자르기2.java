package algo0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 랜선자르기2 {

	static long[] arr;
	static long N, K;
	static long res;
	static long max;

	public static void lan() {
		long start = 1;
		long end = max * 2;

		while (start <= end) {
			long mid = (start + end) / 2;
			long sum = 0;

			for (int i = 0; i < arr.length; i++) {
				sum += arr[i] / mid;
			}

			if (sum >= N) {
				res = Math.max(mid, res);
				start = mid + 1;
			} else {
				end = mid - 1;
			}
			
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		K = Long.parseLong(st.nextToken());
		N = Long.parseLong(st.nextToken());

		arr = new long[(int) N];
		max = 0;

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Long.parseLong(st.nextToken());
			if (arr[i] > max)
				max = arr[i];
		}

		lan();

		System.out.println(res);
	}

}
