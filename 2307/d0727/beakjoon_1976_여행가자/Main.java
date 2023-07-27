import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int parent [];
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		int M = Integer.parseInt(bf.readLine());
		
		parent = new int [N+1];
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		StringTokenizer st;
		for(int i = 1; i <= N; i ++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 1; j <= N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				
				if(temp == 1) {
					union(i,j);
				}
			}
		}
		
		st = new StringTokenizer(bf.readLine());
		int s = Integer.parseInt(st.nextToken());
		int root = find(s);
		
		for(int i = 0; i< M-1; i++) {
			int city = Integer.parseInt(st.nextToken());
			
			if(root != find(city)) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
	
	public static int find(int i) {
		if(i == parent[i]) {
			return i;
		}
		return parent[i] = find(parent[i]);
	}
	
	public static void union(int i , int j) {
		i = find(i);
		j = find(j);
		
		if(i != j) {
			if(i<j) {
				parent[j] = i;
			}else {
				parent[i] = j;
			}
		}
	}

}
