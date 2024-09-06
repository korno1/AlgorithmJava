package algo0905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스티커 {
    static int T;
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());

            arr = new int[2][N];

            for(int i=0; i<2; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=1; i<N; i++){
                arr[0][i] = Math.max(arr[0][i-1], arr[0][i] + arr[1][i-1]);
                arr[1][i] = Math.max(arr[1][i-1], arr[1][i] + arr[0][i-1]);
            }

            sb.append(Math.max(arr[0][N-1], arr[1][N-1])).append("\n");
        }
        System.out.println(sb);

    }
}
