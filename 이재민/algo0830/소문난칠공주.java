package algo0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소문난칠공주 {
    static char[][] map;
    static int N, visited, isPick, start, linkCnt, res;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static boolean rangeCheck(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    static void checkLink(int x, int y) {
        visited |= (1<<x*N+y);

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(!rangeCheck(nx, ny)) continue;
            if((visited & (1<<(nx*N+ny))) != 0) continue;
            if((isPick & (1<<(nx*N+ny))) != 0) {
                linkCnt++;
                checkLink(nx, ny);
            }
        }

    }

    static void combi(int cnt, int idx, int cntY){
        if(cntY >= 4) return;

        if(cnt == 7){
            linkCnt = 1;
            visited = 0;
            checkLink(start / 5, start % 5);
            if(linkCnt == 7) {
                res++;
            }

            return;
        }

        for(int i = idx; i < N*N; i++){
            if(cnt == 0) start = i;
            isPick  |= (1<<i);
            combi(cnt+1, i+1, map[i/5][i%5] == 'S' ? cntY : cntY+1);
            isPick ^=  (1<<i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 5;
        map = new char[N][N];

        for (int i = 0; i < 5; i++) {
            map[i] = br.readLine().toCharArray();
        }

        combi(0, 0, 0);

        System.out.println(res);
    }
}
