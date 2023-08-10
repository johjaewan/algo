import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		for(int t = 0; t < T; t++) {
			
			int N = Integer.parseInt(bf.readLine());
			int dp [][] = new int [N+1][2];
			
			dp[0][0] = 1;
			dp[0][1] = 0;
			
			if(N > 0) {				
				dp[1][0] = 0;
				dp[1][1] = 1;
			}
			
			if(N < 2) {
				System.out.println(dp[N][0] + " " + dp[N][1]);
				continue;
			}
			
			for(int i = 2; i <= N; i++) {
				dp[i][0] = dp[i-1][0] + dp[i-2][0];
				dp[i][1] = dp[i-1][1] + dp[i-2][1];
			}
			System.out.println(dp[N][0] + " " + dp[N][1]);
		}
	}
	
}
