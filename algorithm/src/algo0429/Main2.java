package algo0429;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
	static int p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'P') p++;
			else if (p >= 2 && i < str.length() -1 && str.charAt(i + 1) == 'P') {
				p--;
				i++;
			} else {
				System.out.println("NP");
				System.exit(0);
			}
		}

		if (p == 1) {
			System.out.println("PPAP");
		} else {
			System.out.println("NP");
		}
	}
}