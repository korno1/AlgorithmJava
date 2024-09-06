package algo0730;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    N의 범위가 크지 않음
    브루트포스
    각 사람에 대해서 다른사람과 모두 비교해보고
    더 큰 사람이 몇명인지 세보기
    11588KB | 84ms
 */

public class 덩치 {

    static int N;
    static int[] x;
    static int[] y;

    static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        x = new int[N];
        y = new int[N];
        res = new int[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            int cnt = 0;
            for(int j=0; j<N; j++){
                if(i == j) continue;
                if(x[i] < x[j] && y[i] < y[j])
                    cnt++;
            }
            res[i] = cnt+1;

        }

        for(int i=0; i<N; i++){
            System.out.print(res[i] + " ");
        }
    }
}
