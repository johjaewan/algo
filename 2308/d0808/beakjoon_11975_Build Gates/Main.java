import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int [][] map = new int [4001][4001];
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		String dir = bf.readLine();
		
		int r = 2000;
		int c = 2000;
		map[r][c] = 1;
		
		for(int i = 0; i < N; i++) {
			char d = dir.charAt(i);
			
			int nr = 0, nc = 0;
			
			
			for(int j = 0; j < 2; j++) {
				if(d == 'N') {
					nr = r + dr[0];
					nc = c + dc[0];
				}
				if(d == 'S') {
					nr = r + dr[1];
					nc = c + dc[1];
				}
				if(d == 'W') {
					nr = r + dr[2];
					nc = c + dc[2];
				}
				if(d == 'E') {
					nr = r + dr[3];
					nc = c + dc[3];
				}
				
				map[nr][nc] = 1;
				r = nr;
				c = nc;
			}
		}
		int ans = -1;
		for(int i = 0; i < 4001; i++) {
			for(int j = 0; j < 4001; j++) {
				if(map[i][j] == 0) {
					bfs(i,j);
					ans++;
				}
			}
		}
		
		System.out.println(ans);

	}
	
	public static void bfs(int r, int c) {
		Queue<int[]>q = new LinkedList<>();
		q.add(new int [] {r,c});
		map[r][c] = 1;
		
		while(!q.isEmpty()) {
			int [] temp = q.poll();
			for(int i = 0 ; i < 4; i++) {
				int nr = temp[0] + dr[i];
				int nc = temp[1] + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= 4001 || nc >= 4001) {
					continue;
				}
				
				if(map[nr][nc] == 0) {
					map[nr][nc] = 1;
					q.add(new int [] {nr, nc});
				}
			}
		}
	}

}
