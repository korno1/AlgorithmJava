package algo0130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Solution_1208_Flatten_이재민 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
	
		for(int t=1; t<=10; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int []arr = new int[100];
			for(int i=0; i<100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<n; i++) {
				int max = Arrays.stream(arr).max().getAsInt();
				int indexMax = IntStream.range(0, 100).filter(j -> arr[j]==max).findFirst().getAsInt();
				int min = Arrays.stream(arr).min().getAsInt();
				int indexMin = IntStream.range(0,  100).filter(j -> arr[j]==min).findFirst().getAsInt();
				
				arr[indexMax]--;
				arr[indexMin]++;
			}
			
			int max = Arrays.stream(arr).max().getAsInt();
			int min = Arrays.stream(arr).min().getAsInt();
			
			System.out.println("#" + t + " " + (max - min));
			
			
			
		}
	}

}
