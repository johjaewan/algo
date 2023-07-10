package d0217;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N  = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			
			
			int n = sc.nextInt();
			int coin [] = new int[n];
			
			for (int j = 0; j < n; j++) {	
				coin [j] = sc.nextInt();	
			}
			
			int m = sc.nextInt();
			int dp [] = new int [m+1];
			
			dp[0] = 1;
			
			for (int j = 0; j < coin.length; j++) {
				for (int j2 = 1; j2 <= m; j2++) {
					if(coin[j] <= j2) {
						dp[j2] += dp[j2-coin[j]];
					}
				}
			}
			
			System.out.println(dp[m]);
				
		} 
	}

}
