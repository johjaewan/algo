import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int map [][];
	static boolean visited [];
	public static void main(String[] args)throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		map = new int [N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map [a][b] = 1;
			map [b][a] = 1;
			
		}
		
		visited = new boolean [N+1];
		dfs(V);
		System.out.println();
		visited = new boolean [N+1];
		bfs(V);
	}
	
	public static void dfs(int V) {
		visited[V] = true;
		System.out.print(V+" ");
		
		if(V == map.length) {
			return;
		}
		
		for(int i = 1; i < map.length; i++) {
			if(map[V][i] == 1 && visited[i] == false) {
				dfs(i);
			}
		}
	}
	
	
	public static void bfs(int V) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(V);
		visited[V] = true;
		System.out.print(V + " ");
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int i = 1; i <map.length; i++) {
				if(map[temp][i] == 1 && visited[i] == false) {
					q.add(i);
					visited[i] = true;
					System.out.print(i + " ");
				}
			}
		}
	}

}
