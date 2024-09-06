package algo0708;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 물약구매 {
    static int N;
    static int[] lm;
    static List<Discount>[] dInfo;
    static int res = Integer.MAX_VALUE;

    static class Discount {
        int x, price;
        public Discount(int x, int price) {
            this.x = x;
            this.price = price;
        }
    }

    static void dfs(int s, int cnt, int money){
        if(cnt == N) {
            res = Math.min(res, money);
            return ;
        }

        for(int i = 0; i < dInfo[s].size(); i++){
            Discount d = dInfo[s].get(i);
            lm[d.x] -= d.price;
        }
        for(int i = 1; i<=N; i++){

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        lm = new int[N+1];

        for(int i=1; i<=N; i++){
            dInfo[i] = new ArrayList<>();
        }

        for(int i=1; i<=N; i++){
            lm[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++){
            int c = Integer.parseInt(br.readLine());
            for(int j=1; j<=c; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int price = Integer.parseInt(st.nextToken());
                dInfo[i].add(new Discount(x, price));
            }
        }

        for(int i=1; i<=N; i++){

            dfs(i, 1, lm[i]);
        }


    }
}
