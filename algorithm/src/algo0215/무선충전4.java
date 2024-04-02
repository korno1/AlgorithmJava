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
 * 사용자가 가능한 배터리를 하나 찾았어 
 * 사용자가 2명이야 2개를 찾아야하는데 1개밖에 없으면 걍 한개로 나눠쓰고
 * 2개면 cnt가 2임 -> 두개의 충전량을 그냥 더함
 * 만약 위치가 다른데 겹치는게 있어 
 */
public class 무선충전4 {
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
			APrange(i);
//			System.out.println(i + " " + sum);
			lp[0].r += dy[A[i]];
			lp[0].c += dx[A[i]];
			lp[1].r += dy[B[i]];
			lp[1].c += dx[B[i]];
			System.out.println(i + " " + sum);
		}
		APrange(1);
	}
	
	static void APrange(int idx) {
		boolean[] b = new boolean[APnum];
		//A의  가능한 배터리
		int Ar = lp[0].r;
		int Ac = lp[0].c;
//		System.out.println(Ar + " " + Ac);
		for(int i=0; i<APnum; i++) {
			int br = AP[i].r;
			int bc = AP[i].c;
			int range = AP[i].range;
			if(Math.abs(br-Ar) + Math.abs(bc-Ac) <= range) {
				sum += AP[i].power;
				b[i] = true;
				break;
			}
		}
		
		//B의 가능한 배터리
		int Br = lp[1].r;
		int Bc = lp[1].c;
//		System.out.println(Br + " " + Bc);
		A: for(int i=0; i<APnum; i++) {
			int br = AP[i].r;
			int bc = AP[i].c;
			int range = AP[i].range;
			if(Math.abs(br-Br) + Math.abs(bc-Bc) <= range) {
				if(b[i]) {
					for(int j=i+1; j<APnum; j++) {
						br = AP[j].r;
						bc = AP[j].c;
						range = AP[j].range;
						if(Math.abs(br-Ar) + Math.abs(bc-Ac) <= range) {
							sum += AP[j].power;
							break A;
						}
						else if(Math.abs(br-Br) + Math.abs(bc-Bc) <= range) {
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
			
//			System.out.println(sum);
			sb.append("#" + tc + " " + sum).append('\n');
			
		}
		System.out.println(sb.toString());
	}

}
