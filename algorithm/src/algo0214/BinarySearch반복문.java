package algo0214;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch반복문 {
	static int arr[] = { 2, 4, 7, 9, 11, 19, 23 };

	static int binarySearch(int[] arr, int findNum) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			int midValue = arr[mid];

			// 숫자를 찾은 경우 (찾은 요소의 인덱스 반환)
			if (midValue == findNum) {
				return mid;
			}
			// 찾고자 하는 숫자가 mid보다 오른쪽에 있는 경우
			else if (midValue < findNum) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
			// 찾고자 하는 숫자가 mid보다 왼쪽에 있는 경우

		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int findNum = sc.nextInt();

		int idx = binarySearch(arr, findNum);

		System.out.println("해당 요소의 인덱스 : " + idx);
		System.out.println(Arrays.binarySearch(arr, findNum));
	}
}
