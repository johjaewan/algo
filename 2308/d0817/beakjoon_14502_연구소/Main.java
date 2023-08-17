import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int [][] Map;
	static int N, M;
	static int nm;
	static int dr [] = {-1,0,1,0};
	static int dc [] = {0,1,0,-1};
	static int max = Integer.MIN_VALUE;
	 
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Map= new int [N][M];
		nm = N*M;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j < M; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		find(0,0);
		
		System.out.println(max);
	}
	
	public static void find(int cnt, int start) {
		if(cnt == 3) {
			int temp = bfs();
			max = max > temp ? max : temp;
			return;
		}
		for(int i = start; i < nm; i++) {
			int r = i/M;
			int c = i%M;
			if(Map[r][c] == 0) {				
				Map[r][c] = 1;
				find(cnt+1,i+1);
				Map[r][c] = 0;
			}
		}
	}
	public static int bfs() {
		int cnt = 0;
		Queue<int[]> q = new LinkedList<>();
		int visited[][] = new int [N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(Map[i][j] == 2) {
					q.add(new int[] {i,j});
					visited[i][j] = 2;
					cnt++;
				}
				if(Map[i][j] == 1) {
					cnt++;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int [] now = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) {
					continue;
				}
				
				if(Map[nr][nc] == 0 && visited[nr][nc] == 0) {
					visited[nr][nc] = 2;
					q.add(new int [] {nr, nc});
					cnt++;
				}
			}
		}
		
		return nm-cnt;
	}

}
