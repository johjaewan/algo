package d0214;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [][] dp = new int [N+1][3];
		
		for (int i = 1; i <= N; i++) {
			if(i == 1) {
				
				dp[i][0] = sc.nextInt();
				dp[i][1] = sc.nextInt();
				dp[i][2] = sc.nextInt();
				
			}else {
				int r = sc.nextInt();
				int g = sc.nextInt();
				int b = sc.nextInt();
				dp[i][0] = r + Math.min(dp[i-1][1],dp[i-1][2]); 
				dp[i][1] = g + Math.min(dp[i-1][0],dp[i-1][2]); 
				dp[i][2] = b + Math.min(dp[i-1][0],dp[i-1][1]); 
			}
		}
		System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
	}

}
