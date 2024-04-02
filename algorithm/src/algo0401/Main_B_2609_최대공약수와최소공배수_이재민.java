package algo0401;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_2609_최대공약수와최소공배수_이재민 {
	static int N, M;
	
	static int gcd() {
		int n = N;
		int m = M;
		
		while(n%m != 0) {
			int temp = m;
			m = n%m;
			n = temp;
		}
		
		return m;
	}
	
	static int lcm() {
		return N*M / gcd();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		System.out.println(gcd());
		System.out.println(lcm());
	}
}
