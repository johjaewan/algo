package d0209;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int coin [] = new int [n];
		for (int i = 0; i < coin.length; i++) {
			coin[i] = sc.nextInt();
		}
		
		int dp [] = new int [k+1];
		for (int i = 1; i <= k; i++) {
			int min = Integer.MAX_VALUE-1;
			for(int j = 0;j < n; j++) {
				if(i>=coin[j]) {
					min = Math.min(min, dp[i-coin[j]]+1);
				}
			}
			dp[i]=min;
		}
		if(dp[k]==Integer.MAX_VALUE-1) {
			System.out.println(-1);
		}else {
			System.out.println(dp[k]);
		}
	}

}
