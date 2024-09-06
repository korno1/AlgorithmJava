package algo0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 양dfs {

    static int R, C;
    static int wolf, sheep, w, s;
    static char[][] map;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static boolean[][] visited;
    static boolean isRange(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
    }


    static void dfs(int x, int y){
        visited[x][y] = true;
        if(map[x][y] == 'o') s++;
        else if(map[x][y] == 'v') w++;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(!isRange(nx, ny)) continue;
            if(visited[nx][ny]) continue;
            if(map[nx][ny] == '#') continue;
            dfs(nx, ny);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            map[i] = line.toCharArray();
        }

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(map[i][j] != '#' && !visited[i][j]){
                    w = s = 0;
                    dfs(i, j);
                    if(s > w) sheep += s;
                    else wolf += w;
                }
            }
        }

        System.out.println(sheep + " " + wolf);

    }
}
