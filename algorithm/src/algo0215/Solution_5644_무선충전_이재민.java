package algo0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 배터리를 충전량 별로 정렬
 * 가장 먼저 찾은 배터리(범위 안에있는 배터리)가 충전량이 가장 큰 것
 * bool 배열로 A에서 먼저 찾으면 B에서 A와 B를 둘다 돌려 먼저 찾는 것을 고르기
 * 28316KB | 202ms
 */
public class Solution_5644_무선충전_이재민 {
	static int M, APnum;
	static int[] A, B;
	static APInfo[] AP;
	static Location[] lp;
	static int sum;
	static int[] dx = {0, -1, 0, 1, 0};
	static int[] dy = {0, 0, 1, 0, -1};
	
	static class APInfo {
		int r, c, range, power;

		public APInfo(int r, int c, int range, int power) {
			this.r = r;
			this.c = c;
			this.range = range;
			this.power = power;
		}

	}

	static class Location{
		int r, c;

		public Location(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	
	static void move() {
		for(int i=0; i<M; i++) {
			APrange();
			lp[0].r += dy[A[i]];
			lp[0].c += dx[A[i]];
			lp[1].r += dy[B[i]];
			lp[1].c += dx[B[i]];
			System.out.println(i + " " + sum);
		}
		APrange();
	}
	
	static void APrange() {
		boolean[] b = new boolean[APnum];
		//A의  가능한 배터리
		int Ar = lp[0].r;
		int Ac = lp[0].c;
		
		for(int i=0; i<APnum; i++) {
			int batteryR = AP[i].r;
			int batteryC = AP[i].c;
			int range = AP[i].range;
			if(Math.abs(batteryR-Ar) + Math.abs(batteryC-Ac) <= range) {
				sum += AP[i].power;
				b[i] = true;
				break;
			}
		}
		
		//B의 가능한 배터리
		int Br = lp[1].r;
		int Bc = lp[1].c;
		A: for(int i=0; i<APnum; i++) {
			int batteryR = AP[i].r;
			int batteryC = AP[i].c;
			int range = AP[i].range;
			if(Math.abs(batteryR-Br) + Math.abs(batteryC-Bc) <= range) {
				if(b[i]) {
					for(int j=i+1; j<APnum; j++) {
						batteryR = AP[j].r;
						batteryC = AP[j].c;
						range = AP[j].range;
						if(Math.abs(batteryR-Ar) + Math.abs(batteryC-Ac) <= range) {
							sum += AP[j].power;
							break A;
						}
						else if(Math.abs(batteryR-Br) + Math.abs(batteryC-Bc) <= range) {
							sum += AP[j].power;
							break A;
						}
					}
					break;
				}
				sum += AP[i].power;
				break;
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			APnum = Integer.parseInt(st.nextToken());
			A = new int[M];
			B = new int[M];
			AP = new APInfo[APnum];
			lp = new Location[] {new Location(1, 1), new Location(10, 10)};
			sum = 0;
			for(int i=0; i<2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					if(i==0)
						A[j] = Integer.parseInt(st.nextToken());
					else B[j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < APnum; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int range = Integer.parseInt(st.nextToken());
				int power = Integer.parseInt(st.nextToken());
				AP[i] = new APInfo(r, c, range, power);
			}
			Arrays.sort(AP, (a, b) -> b.power - a.power);
			
			move();
			
			sb.append("#" + tc + " " + sum).append('\n');
			
		}
		System.out.println(sb.toString());
	}

}
