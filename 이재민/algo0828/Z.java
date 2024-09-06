package algo0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z {
    static int N, R, C;

    static void recur(int size, int r, int c, int cnt){

        if(size == 1){
            System.out.println(cnt);
            return;
        }

        // 왼쪽 위
        if(r < size / 2 && c < size / 2){
            recur(size/2, r, c, cnt);
        }

        // 오른쪽 위
        else if(r < size / 2 && c >= size / 2){
            recur(size/2, r, c - size / 2, cnt + (size * size) / 4);
        }

        // 왼쪽 아래
        else if(r >= size / 2 && c < size / 2) {
            recur(size / 2, r - size / 2, c, cnt + (size * size) / 4 * 2);
        }

        else {
            recur(size / 2, r - size / 2, c - size / 2, cnt + (size * size) / 4 * 3);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int size = (int)Math.pow(2, N);

        recur(size, R, C, 0);

    }
}
