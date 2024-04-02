package algo0201;
import java.util.Arrays;
import java.util.Scanner;
/**
 * 
N개의 요소 중 R개의 뽑는 모든 경우의 수를 출력하기
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
8 9
8 10
9 10
====
 */
public class combination_Q {
    static int N;    //arr의 크기(요소의 개수
    static int R;    //뽑을 개수
    
    static int[] arr;
    static int[] picked;
    
    static StringBuilder sb = new StringBuilder();
    
    static void combi(int cnt, int idx) {
    	if(cnt == R) {
    		Arrays.stream(picked).forEach(x -> sb.append(x + " "));
    		sb.append("\n");
    		return ;
    	}
    	
    	for(int i=idx; i<N; i++) {
    		picked[cnt] = arr[i];
    		combi(cnt+1, i+1);
    	}
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        R = sc.nextInt();
        
        arr = new int[N];
        picked = new int[R];
        
        for(int i=0; i<N; i++) arr[i] = sc.nextInt();
        
        combi(0, 0);
        
        System.out.println(sb.toString());
//        for(int i=1; i<(1<<N); i++) {
//        	if(Integer.bitCount(i) == R) {
//        		for(int j=0; j<N; j++) {
//        			if((i & (1<<j))!= 0) {
//        				System.out.print(arr[j] + " ");
//        			}
//        		}
//        		System.out.println();
//        	}
//        }
        
        
        
        
    }


    
}