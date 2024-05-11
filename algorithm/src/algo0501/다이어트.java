package algo0501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다이어트 {
    static int N, mMp, mMf, mMs, mMv;
    static food[] f;
    static boolean[] isSelected;
    static int res;
    static class food {
        int mp, mf, ms, mv, price;
        // 단백질, 지방, 탄수화물, 비타민

        public food(int mp, int mf, int ms, int mv, int price) {
            this.mp = mp;
            this.mf = mf;
            this.ms = ms;
            this.mv = mv;
            this.price = price;
        }

    }

    static void combi(int cnt, int mp, int mf, int ms, int mv, int price) {
        if(price >= res)
            
        
        if(mp >= mMp && mf >= mMf && ms >= mMs && mv >= mMv) {
            return;
        }
        
        isSelected[cnt] = true;
        
        isSelected[cnt] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        f = new food[N];
        isSelected = new boolean[N];
        res = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        mMp = Integer.parseInt(st.nextToken());
        mMf = Integer.parseInt(st.nextToken());
        mMs = Integer.parseInt(st.nextToken());
        mMv = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int mp = Integer.parseInt(st.nextToken());
            int mf = Integer.parseInt(st.nextToken());
            int ms = Integer.parseInt(st.nextToken());
            int mv = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            f[i] = new food(mp, mf, ms, mv, price);
        }

    }
}