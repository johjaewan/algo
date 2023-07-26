import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int [] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		parent = new int [n+1];
		
		for(int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		
		for(int i = 1; i <= m; i++) {
			st = new StringTokenizer(bf.readLine());
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			
			if(op == 1) {
				boolean eq = eqparents(a,b);
				if(eq) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}else {
				union(a,b);
			}
		}
		
		
		
	}
	static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		
		if(x < y) {
			parent[y] = x;
		}else {
			parent[x] = y;
		}
	}
	
	static int find (int a) {
		if(parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}
	
	static boolean eqparents(int a, int b) {
		int x = find(a);
		int y = find(b);
		return x == y;
	}

}
