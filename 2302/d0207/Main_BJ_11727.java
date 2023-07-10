package d0207;

import java.util.Scanner;

public class Main_BJ_11727 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] dp = new int[N+1];
		dp[1] = 1;
		dp[2] = 3;
		for (int i = 3; i <= N; i++) {
			dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
		}

		System.out.println(dp[N]);
	}

}
