package d0210;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if(N<5) {
            if(N==3) System.out.println(1);
            else System.out.println(-1);
            return;
        }

		int dp[] = new int[N + 1];
		Arrays.fill(dp, 5001);
		dp[3] = 1;
		dp[5] = 1;
		for (int i = 6; i <= N; i++) {
			dp[i] = Math.min(dp[i - 3]+1, dp[i - 5]+1);
		}
		if (dp[N] > 5001) {
			System.out.println(-1);
		} else {
			System.out.println(dp[N]);
		}
	}
}
