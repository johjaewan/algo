package d0208;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		int c[] = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			c[i] = sc.nextInt();
		}

		int dp[] = new int[K + 1];

		dp[0] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = c[i]; j <= K; j++) {
				dp[j] = dp[j] + dp[j - c[i]];
			}
		}

		System.out.println(dp[K]);
	}
}
