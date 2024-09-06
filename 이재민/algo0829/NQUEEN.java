package algo0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQUEEN {

    static int N;
    static boolean[] row, col;
    static int res;

    static boolean check(int idx){
        if(col[idx]) return false;
        return true;
    }

    static void dfs(int cnt, int r){
        if(cnt == N){
            res++;
            return;
        }
        for(int i=0; i<N; i++){
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

//        row = new boolean[N];
        col = new boolean[N];
    }
}
