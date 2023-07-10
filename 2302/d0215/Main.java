package d0215;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] map = new int[N + 1][M + 1];
		int[][] dp = new int[N + 1][M + 1];
		
		for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                map[i][j] = sc.nextInt();
            }
        }
		for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                dp[i][j] = Math.max(map[i][j]+dp[i-1][j], map[i][j]+dp[i][j-1]);
            }
        }
		
		System.out.println(dp[N][M]);

	}
}
