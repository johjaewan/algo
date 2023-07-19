import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int Map[][];
	static int dr[] = {0,1,0,-1};
	static int dc[] = {1,0,-1,0};
	static int N;
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
	
		N = Integer.parseInt(st.nextToken());
		Map = new int [N][N];
		
		for(int i = 0; i < N; i++) {
			String line = bf.readLine();
			for(int j = 0; j < N; j++) {
				Map[i][j] = line.charAt(j)-'0';
			}
		}
		int answer = 0;
		for(int i = 0 ; i < N; i ++) {
			for(int j = 0; j < N; j++) {
				if(Map[i][j] == 1) {
					bfs(i,j);
					answer ++;
				}
			}
		}
		Collections.sort(list);
		
		System.out.println(answer);
		for(int temp : list) {
			System.out.println(temp);
		}
	}
	
	public static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {r,c});
		int cnt = 0;
		Map[r][c] = 2;
		
		while(!q.isEmpty()) {
			int now [] = q.poll();
			cnt ++;
			
			for(int i = 0; i < 4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];
				
				if(nr < 0 || nc < 0|| nr >= N|| nc >= N) {
					continue;
				}
				
				if(Map[nr][nc] == 1) {
					q.add(new int [] {nr, nc});
					Map[nr][nc] = 2;
				}
			}
		}
		list.add(cnt);
	}

}
