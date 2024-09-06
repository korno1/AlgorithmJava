package algo0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 양 {

    static int R, C;
    static int wolf, sheep;
    static char[][] map;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static boolean[][] visited;
    static boolean isRange(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    static class Loc {
        int x, y;
        Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y){
        Queue<Loc> q = new ArrayDeque<>();
        q.add(new Loc(x, y));
        visited[x][y] = true;
        int s = 0, w = 0;
        if(map[x][y] == 'o') s++;
        else if(map[x][y] == 'v') w++;

        while(!q.isEmpty()){
            Loc loc = q.poll();

            for(int d=0; d<4; d++){
                int nx = loc.x + dx[d];
                int ny = loc.y + dy[d];
                if(!isRange(nx, ny)) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] == '#') continue;
                visited[nx][ny] = true;
                if(map[nx][ny] == 'o') s++;
                else if(map[nx][ny] == 'v') w++;
                q.add(new Loc(nx, ny));
            }
        }

        if(s > w) sheep += s;
        else wolf += w;
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
                    bfs(i, j);
                }
            }
        }

        System.out.println(sheep + " " + wolf);

    }
}
