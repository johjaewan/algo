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

		int c[] = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			c[i] = Integer.parseInt(st.nextToken());
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
