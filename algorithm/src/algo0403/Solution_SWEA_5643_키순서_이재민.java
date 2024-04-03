package algo0403;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
 
/*
 * 역으로 된 리스트를 하나 더 만들어서
 * i번째 학생보다 작은 애들과 큰 애들의 수를 구함
 * 두개를 더했을때 N-1이 나온다면 자신의 순서를 아는 것
 * 102908KB | 1321ms
 */
public class Solution_SWEA_5643_키순서_이재민 {
 
    static int N, M, cnt, res;
    static List<Integer>[] list;
    static List<Integer>[] ReverseList;
    static boolean[] visited;
     
    static void dfs(List<Integer>[] l, int x) {
        visited[x] = true;
         
        for(int i=0; i<l[x].size(); i++) {
            int nx = l[x].get(i);
            if(visited[nx]) continue;
            cnt++;
            dfs(l, nx);
        }
    }
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
         
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=T; tc++) {
            sb.append("#" + tc + " ");
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            visited = new boolean[N+1];
            list = new List[N+1];
            ReverseList = new List[N+1];
            res = 0;
            for(int i=1; i<=N; i++) {
                list[i] = new ArrayList<>();
                ReverseList[i] = new ArrayList<>();
            }
             
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                 
                list[x].add(y);
                ReverseList[y].add(x);
            }
             
            for(int i=1; i<=N; i++) {
                Arrays.fill(visited, false);
                cnt = 0;
                dfs(list, i);
                dfs(ReverseList, i);
                if(cnt == N-1) res++;
            }
             
            sb.append(res).append('\n');
        }
        System.out.println(sb);
         
    }
 
}