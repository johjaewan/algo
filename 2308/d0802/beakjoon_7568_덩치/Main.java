import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int W[] = new int [N];
		int H[] = new int [N];
		int R[] = new int [N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			H[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			int cnt = 1;
			
			for(int j = 0; j < N; j++) {
				if(i == j) {
					continue;
				}
				if(W[i] < W[j] && H[i] < H[j]) {
					cnt += 1;
				}
			}
			R[i] = cnt;
			
		}
		for(int i = 0; i < N; i++) {
			System.out.print(R[i] + " ");
		}
	}

}
