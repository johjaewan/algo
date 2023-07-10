package d0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(bf.readLine());
		
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int W [] = new int [N+1];
		int V [] = new int [N+1];
		int dp [] = new int [K+1];
		
		for (int i = 1; i <=N ; i++ ) {
			st = new StringTokenizer(bf.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i<=N; i++) {
			for(int j = K; j >= W[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j-W[i]]+V[i]);
			}
		}
		System.out.println(dp[K]);
	}
}
