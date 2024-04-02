package algo0130;

public class Loop_Permu {

	// N P R
	int N = 5; // 1 ~ 5까지의 숫자
	int R = 3; // 뽑을 개수
	int idx = 1;
	
	
	
	public static void main(String[] args) {
		Loop_Permu lp = new Loop_Permu();
		for(int i=1; i<=lp.N; i++) {
			for(int j=1; j<=lp.N; j++) {
				if(i==j) continue;
				for(int k=1; k<=lp.N; k++) {
					if(j==k || i==k) continue;
					System.out.println(lp.idx++ + " " +i + " " + j + " " + k);
				}
			}
		}
	}

}
