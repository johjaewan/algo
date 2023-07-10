package d0207;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		
		int [] V = new int [N+1];
		for(int i = 1 ; i <= N; i++) {
			V[i] = sc.nextInt();
		}
		
		int [] dp = new int [N+1];
		dp[0] = 0;
		for (int i = 1; i <=N; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 1; j<=N; j++) {
				if(i>=j) {
					max = Math.max(max, dp[i-j]+V[j]);
				}
			}
			dp[i] = max;
		}
		System.out.println(dp[N]);	
	}

}
