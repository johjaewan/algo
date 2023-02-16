package d0216;


import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int dpM [][] = new int [N+1][3];
		int dpm [][] = new int [N+1][3];
		
		for (int i = 0; i < 3; i++) {
			dpM[1][i] = sc.nextInt();
			dpm[1][i] = dpM[1][i];
		}
		
		for (int i = 2; i <=N ; i++) {
			int one = sc.nextInt();
			int two = sc.nextInt();
			int three = sc.nextInt();
			dpM[i][0] = Math.max(dpM[i-1][0], dpM[i-1][1])+ one;
			dpM[i][1] = Math.max(dpM[i-1][0], Math.max(dpM[i-1][1], dpM[i-1][2]))+ two;
			dpM[i][2] = Math.max(dpM[i-1][1], dpM[i-1][2])+ three;
			
			dpm[i][0] = Math.min(dpm[i-1][0], dpm[i-1][1])+ one;
			dpm[i][1] = Math.min(dpm[i-1][0], Math.min(dpm[i-1][1], dpm[i-1][2]))+ two;
			dpm[i][2] = Math.min(dpm[i-1][1], dpm[i-1][2])+ three;
		}
		
		System.out.println(Math.max(dpM[N][0], Math.max(dpM[N][1], dpM[N][2]))+" "+Math.min(dpm[N][0], Math.min(dpm[N][1], dpm[N][2])));
	}

}
