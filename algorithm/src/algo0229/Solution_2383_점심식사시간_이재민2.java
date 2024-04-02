package algo0229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 부분집합으로 어디 계단으로 갈지 집합 구성
 * people에 계단과의 거리, 어느 계단을 갈 것인지 저장
 * 내려가는 함수 수행 시 내려가는 것을 먼저 하고 이후 계단과의 거리를 좁혀서 0이 되면 계단에 내려가는 대기상태로 둠
 * 계단에 인원이 3미만이면 계단에 내려갈 수 있는 상태로 설정하고 수행
 * 23272KB | 179ms
 */
public class Solution_2383_점심식사시간_이재민2 {

	static int N, res, time, picked;
	static int[][] map;
	static List<People> people;
	static Stair stair[];

	static class People {
		int r, c, dist, stairNum, downCount;
		boolean flag, downflag;

		public People(int r, int c) {
			super();
			this.r = r;
			this.c = c;
			this.dist = 0;
			this.stairNum = 0;
			this.downCount = 0;
			this.flag = false;
			this.downflag = false;
		}

	}

	static class Stair {
		int r, c, len, count;

		public Stair(int r, int c, int len) {
			this.r = r;
			this.c = c;
			this.len = len;
			this.count = 0;
		}

	}

	static void down() {
		time = 1;
		int count = 0;
		int downflagCount = 0;
		while (true) {
			time++;
			if (downflagCount != 0) {
				for (int i = 0; i < people.size(); i++) {
					// 내려가는 사람이라면
					if (people.get(i).downflag) {
						people.get(i).downCount--;
						if (people.get(i).downCount == 0) {
							people.get(i).downflag = false;
							stair[people.get(i).stairNum].count--;
							people.get(i).dist = -2;
							downflagCount--;
							count++;
						}
					}
				}
			}

			for (int i = 0; i < people.size(); i++) {
				if (people.get(i).dist > 0)
					people.get(i).dist--;
				if (people.get(i).dist == 0) {
					people.get(i).flag = true;
				}

				if (people.get(i).flag) {
					if (stair[people.get(i).stairNum].count >= 3)
						continue;
					stair[people.get(i).stairNum].count++;
					people.get(i).downflag = true;
					downflagCount++;
					people.get(i).flag = false;
					people.get(i).downCount = stair[people.get(i).stairNum].len;
					people.get(i).dist = -1;
				}
			}

			if (count == people.size())
				break;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			stair = new Stair[2];
			people = new ArrayList<>();
			res = Integer.MAX_VALUE;

			int peopleCount = 0;
			int sIdx = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						people.add(new People(i, j));
						peopleCount++;
					} else if (map[i][j] != 0)
						stair[sIdx++] = new Stair(i, j, map[i][j]);
				}
			}

			// 비트마스킹
			for (int i = 0; i < (1 << peopleCount); i++) {
				picked = 0;
				stair[0].count = 0;
				stair[1].count = 0;
				for (int j = 0; j < peopleCount; j++) {
					people.get(j).dist = 0;
					people.get(j).stairNum = 100;
					people.get(j).downCount = 0;
					people.get(j).flag = false;
					people.get(j).downflag = false;

					if ((i & (1 << j)) != 0) {
						picked = picked | (1 << j);
						people.get(j).dist = Math.abs(people.get(j).r - stair[0].r)
								+ Math.abs(people.get(j).c - stair[0].c);
						people.get(j).stairNum = 0;
					} else {
						people.get(j).dist = Math.abs(people.get(j).r - stair[1].r)
								+ Math.abs(people.get(j).c - stair[1].c);
						people.get(j).stairNum = 1;
					}
				}
				down();

				res = Math.min(res, time);
			}
			sb.append("#" + tc + " " + res).append('\n');
		}
		System.out.println(sb);
	}

}
