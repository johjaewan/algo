import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int map[][];
	static int visited[][];
	static int M, N, K;
	static int cnt;
	static int nr, nc;
	static int dc[] = {-1,1,0,0};
	static int dr[] = {0,0,-1,1};
	
  	public static void main(String[] args) throws IOException {
  		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  		StringTokenizer st;
  		
  		int T = Integer.parseInt(bf.readLine());
  		for(int t = 0; t<T; t++) {
  			st = new StringTokenizer(bf.readLine());
  			M = Integer.parseInt(st.nextToken());
  			N = Integer.parseInt(st.nextToken());
  			K = Integer.parseInt(st.nextToken());
  			
  			map = new int [N][M];
  			visited = new int [N][M];
  			cnt = 0;
  			
  			for(int i = 0; i <K; i++) {
  				st = new StringTokenizer(bf.readLine());
  				int c = Integer.parseInt(st.nextToken());
  				int r = Integer.parseInt(st.nextToken());
  				map[r][c] = 1;
  			}
  			
  			for(int i = 0; i < N; i++) {
  				for(int j = 0; j < M; j++) {
  					if(map[i][j] == 1 && visited[i][j] == 0) {
  						dfs(i,j);
  						cnt++;
  					}
  				}
  			}
  			System.out.println(cnt);
  		}
	}
  	
  	public static void dfs(int r, int c) {
  		visited[r][c] = 1;
 
  		for(int i = 0; i < 4; i++) {
  			nr = r + dr[i];
  			nc = c + dc[i];
  			if(nr < 0 || nc < 0 || nr >= N || nc >= M) {
  				continue;
  			}
  			if(visited[nr][nc] == 0 && map[nr][nc] == 1) {
  				dfs(nr, nc);
  			}
  		}
  	}

}
