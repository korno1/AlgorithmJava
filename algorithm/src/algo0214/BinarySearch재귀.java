package algo0214;

public class BinarySearch재귀 {
	static int arr[] = {2, 4, 7, 9, 11, 19, 23};
	static int res = 7;
	static int idx;
	
	public static void bs(int l, int r) {
		int mid = (l+r) / 2;
		if(arr[mid] == res) {
			idx = mid;
			return ;
		}
		
		if(arr[mid] > res) bs(l, mid-1);
		else if(arr[mid] < res) bs(mid+1, r);
	}
	
	public static void main(String[] args) {
		bs(0, 7);
		
		System.out.println(idx);
	}

}
