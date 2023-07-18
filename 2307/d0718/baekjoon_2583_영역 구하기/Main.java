import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;



public class Main {
	
	static int N,M,K;
	
	static int dr [] = {-1,1,0,0};
	static int dc [] = {0,0,-1,1};
	
	static int map[][];
	static int cnt;
	static ArrayList<Integer> list;

	public static void main(String[] args)throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int [M][N];
		list = new ArrayList<>();
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(bf.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			
			for (int r = r1; r < r2; r++) {
				for (int c = c1; c < c2; c++) {
					map[r][c] = 1;
				}
			}
		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0) {
					cnt = 0;
					dfs(i,j);
					list.add(cnt);
				}
			}
		}
		
		System.out.println(list.size());
		Collections.sort(list);
		for (Integer num : list) {
			System.out.print(num + " ");
		}	
	}
	
	public static void dfs(int r, int c) {
		map[r][c] = 1;
		cnt ++;
		for(int i = 0; i < 4; i ++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nc < 0 || nr >= M || nc >= N) {
				continue;
			}
			if(map[nr][nc] == 0) {
				dfs(nr,nc);
			}
		}
	}

}
