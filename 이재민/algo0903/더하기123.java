package algo0903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 더하기123 {
    static int N, K;
    static int count;
    static int[] arr;
    static void plus(int sum, int cnt){
        if(sum > N) return;

        if(sum == N){
//            System.out.println(sum);
            count++;
            if(count == K){
                for(int i=0; i<cnt; i++){
                    if(i == cnt-1){
                        System.out.println(arr[i]);
                    }
                    else
                        System.out.print(arr[i] + "+");
                }
                System.exit(0);
            }
            return;
        }

        for(int i=1; i<=3; i++){
            arr[cnt] = i;
            plus(sum+i, cnt+1);

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        plus(0, 0);
        System.out.println(-1);
    }
}
