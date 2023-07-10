package d0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int Map [][];
	static int ans;
	static int [] dr = {0,1,0,-1};
	static int [] dc = {1,0,-1,0};
	static int visited [][];
	
	static void dfs(int r, int c, int cnt, int val) {
		if(cnt == 4) {
			ans = Math.max(ans, val);
			return;
		}
		int nr, nc;
		for (int i = 0; i < 4; i++) {
			nr = r+ dr[i];
			nc = c+ dc[i];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M) {
				continue;
			}
			
			if(visited[nr][nc] == 0) {
				if(cnt == 2) {
					visited[nr][nc] = 1;
					dfs(r,c,cnt+1,val + Map[nr][nc]);
					visited[nr][nc] = 0;
				}
				visited[nr][nc] = 1;
				dfs(nr,nc,cnt+1,val + Map[nr][nc]);
				visited[nr][nc] = 0;
			}
			
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Map = new int [N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = -1;
		visited = new int [N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = 1;
				dfs(i,j,1,Map[i][j]);
				visited[i][j] = 0;
			}
		}
		System.out.println(ans);
	}

}