package algo0201;
/*
 * 시간 복잡도로 인해 for문을 한번만 돌림
 * 투포인터를 이용해 int배열에 값을 넣고 빼는것으로
 * 연산
 * 21572KB | 240ms
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_B_12891_DNA비밀번호_이재민 {
	
	static int[] arr;
	static int[] num;
	static int[] check;
	static int res, n, r;
	static String s;

	static boolean check_str() {
		return num[0] >= arr[0] && num[1] >= arr[1] && num[2] >= arr[2] && num[3] >= arr[3];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		s = br.readLine();
		arr = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		check = new int[4];
		
		// 처음에 체크해서 개수가 적으면 바로 끝내기
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == 'A') check[0] ++;
			else if(s.charAt(i) == 'C') check[1]++;
			else if(s.charAt(i) == 'G') check[2]++;
			else if(s.charAt(i) == 'T') check[3]++;
		}
		
		for(int i=0; i<4; i++) {
			if(check[i] < arr[i]) {
				System.out.println(0);
				System.exit(0);
			}
		}
		
		
		num = new int[4];
		// 처음 r개
		for(int i=0; i<r; i++) {
			if(s.charAt(i) == 'A') num[0] ++;
			else if(s.charAt(i) == 'C') num[1]++;
			else if(s.charAt(i) == 'G') num[2]++;
			else if(s.charAt(i) == 'T') num[3]++;
		}
		if(check_str()) res++;
		
		// 이후 한쪽을 더하고 앞쪽을 빼서 계싼
		for(int i=r; i<n; i++) {
			if(s.charAt(i) == 'A') num[0] ++;
			else if(s.charAt(i) == 'C') num[1]++;
			else if(s.charAt(i) == 'G') num[2]++;
			else if(s.charAt(i) == 'T') num[3]++;

			if(s.charAt(i-r) == 'A') num[0] --;
			else if(s.charAt(i-r) == 'C') num[1]--;
			else if(s.charAt(i-r) == 'G') num[2]--;
			else if(s.charAt(i-r) == 'T') num[3]--;
			
			if(check_str()) res++;
		}
		
		System.out.println(res);
		
	}

}
