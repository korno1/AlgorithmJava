package algo0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 5kg의 봉지를 최대 개수로 초기화하고 (5kg이 많을 수록 봉지가 줄어듬)
 * 봉지 개수를 줄여가며 정확한 N킬로그램이 되는지 체크
 * 5kg 봉지가 -1이 되면 정확한 N킬로그램이 안된다는 것
 * 
 * 11524KB | 84ms
 */
public class Main_B_2839_설탕배달_이재민 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int m5 = n / 5; // 5kg
		int m3 = 0; // 3kg;

		while (m5 > -1) {
			if ((n - m5 * 5) % 3 == 0) {
				m3 = (n - m5 * 5) / 3;
				break;
			}

			m5--;
		}

		System.out.println(m5 == -1 ? -1 : m5 + m3);

	}

}
