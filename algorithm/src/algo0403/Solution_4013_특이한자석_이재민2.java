package algo0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * system.arraycopy를 사용해서 덱처럼 이동
 * 미리 방향을 전부 정해주고 방향에 맞게 회전
 * 26372KB | 117ms
 */

public class Solution_4013_특이한자석_이재민2 {
	static int[][] magnetic;
	static int K, res;
	static int[] score = {1, 2, 4, 8};
	static int[] rotate;
	static void rotateMagnetic(int[] rotate) {
		
		for(int i=0; i<4; i++) {
			// 시계방향 회전으로 맨 뒤를 맨 앞으로
			if(rotate[i] == 0) continue;
			if(rotate[i] == 1) {
				int temp = magnetic[i][7];
				System.arraycopy(magnetic[i], 0, magnetic[i], 1, 7);
				magnetic[i][0] = temp;
			}
			else if(rotate[i] == -1) {
				int temp = magnetic[i][0];
				System.arraycopy(magnetic[i], 1, magnetic[i], 0, 7);
				magnetic[i][7] = temp;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=T; tc++) {
			K = Integer.parseInt(br.readLine());
			sb.append("#" + tc + " ");
			magnetic = new int[4][8];
			res = 0;
			for(int i=0; i<4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<8; j++) {
					magnetic[i][j] = Integer.parseInt(st.nextToken());
					
				}
			}
			rotate = new int[4];
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				
				num--;
				rotate[num] = dir;
				
				// 왼쪽 회전방향 정해주기
				for(int j=num; j>0; j--) {
					if(rotate[j] == 0) break;
					
					if(magnetic[j][6] != magnetic[j-1][2]) {
						rotate[j-1] = rotate[j] * (-1);
					}
				}
				
				// 오른쪽 회전뱡향 정해주기
				for(int j=num; j<3; j++) {
					if(rotate[j] == 0) break;
					
					if(magnetic[j][2] != magnetic[j+1][6]) {
						rotate[j+1] = rotate[j] * (-1);
					}
				}
				// 회전
				rotateMagnetic(rotate);
				Arrays.fill(rotate, 0);
			}
			
			for(int i=0; i<4; i++) {
				if(magnetic[i][0] == 1) {
					res += score[i];
				}
			}
			
			sb.append(res).append('\n');
			
		}
		System.out.println(sb);
		
	}

}
