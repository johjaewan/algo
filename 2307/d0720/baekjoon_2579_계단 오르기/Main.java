import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int [] arr = new int [N+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int dp[] = new int [N+1];
		if(N == 1) {
			dp[1] = arr[1];
		}else if (N == 2){
			dp[2] = arr[1] + arr[2];
		}else if (N == 3) {
			dp[3] = Math.max(arr[1],arr[2])+arr[3];
		}else {
			dp[1] = arr[1];
			dp[2] = arr[1] + arr[2];
			dp[3] = Math.max(arr[1],arr[2])+arr[3];
			
			for(int i = 4 ; i <= N; i++) {
				dp[i] = Math.max(dp[i-3]+arr[i-1], dp[i-2])+arr[i];
			}
		}
		
		System.out.println(dp[N]);
	}

}
