package algo0201;
import java.util.Arrays;
import java.util.Scanner;
/**
 * 
N개 중 R개의 요소를 뽑아 나열하는 모든 경우의 수 구하기
출력 시, StringBuilder를 사용하자.

입력 예시
N R
배열 요소
====
4 2
7 8 9 10

====

출력 예시
====
7 8
7 9
7 10
8 7
8 9
8 10
9 7
9 8
9 10
10 7
10 8
10 9
====
 */
public class permutation_Q {
    static int N;    //arr의 크기(요소의 개수
    static int R;    //뽑을 개수
    
    static int[] arr;
    static int[] picked;
    static boolean[] check;
    
    static StringBuilder sb = new StringBuilder();
    
    static void permu(int cnt) {
    	if(cnt == R) {
    		
    		Arrays.stream(picked).forEach(x -> sb.append(x + " "));
    		sb.append('\n');
    		return ;
    	}
    	
    	for(int i=0; i<N; i++) {
    		if(check[i]) continue;
    		check[i] = true;
    		picked[cnt] = arr[i];
    		permu(cnt+1);
    		check[i] = false;
    	}
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        R = sc.nextInt();
        
        arr = new int[N];
        picked = new int[R];
        check = new boolean[N];
   
        
        for(int i=0; i<N; i++) arr[i] = sc.nextInt();
        
        
        permu(0);
        
        
        System.out.println(sb.toString());
    }


    
}