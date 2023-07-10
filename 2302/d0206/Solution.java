package d0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int W[] = new int[N + 1];
		int V[] = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}

		int dp[][] = new int[N+1][K+1];

		for (int n = 1; n <= N; n++) {
			for (int k = 1; k <= K; k++) {
				if(W[n] > k) {
					dp[n][k] = dp[n-1][k];
				}else {
					dp[n][k] = Math.max(dp[n-1][k],dp[n-1][k-W[n]]+V[n]);
				}
			}
		}
		
		System.out.println(dp[N][K]);

	}

}
