package algo0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * C개 중 L개를 뽑아 사전식으로 출력하는 문제
 * 조합을 뽑을 때 index 순서대로 뽑기 때문에 미리 정렬을 하고 뽑기
 * 모음과 자음의 개수를 매개변수로 주고 조건에 맞으면 출력
 * 11868KB | 88ms
 */

public class Main_B_1759_암호만들기_이재민 {
	static int L, C;
	static char[] ch;
	static char[] picked;
	static void combi(int cnt, int idx, int vowel, int cons) {
		if(cnt == L) {
			if(vowel >= 1 && cons >= 2) 
				System.out.println(picked);
			return ;
		}
		
		for(int i=idx; i<C; i++) {
			picked[cnt] = ch[i];
			if(ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'o' || ch[i]=='i' || ch[i]=='u')
//			if("aeiou".contains(Character.toString(ch[i])))
				combi(cnt+1, i+1, vowel+1, cons);
			else
				combi(cnt+1, i+1, vowel, cons+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		picked = new char[L];
		

		Arrays.sort(ch = br.readLine().replace(" ", "").toCharArray());
		combi(0, 0, 0, 0);
		
	}

}
