import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R, C, D;
	static int Map [][];
	static int [] dr = {-1, 0, 1, 0};
	static int [] dc = {0, 1, 0, -1};
	static int answer = 1;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		Map = new int [N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < M; j++) {
            	Map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
		
		sol(R,C,D);
		System.out.println(answer);
	}
	
	public static void sol (int r, int c, int d) {
		Map[r][c] = -1;
		
		for (int i = 0; i < 4; i++) {
			d = (d+3)%4;
			int nr = r + dr [d];
			int nc = c + dc [d];
			if(nr < 0 || nc < 0 || nr >=N || nc >= M) {
				continue;
			}
			if(Map[nr][nc] == 0) {
				answer ++;
				sol (nr, nc, d);
				return;
			}
		}
		
		int back = (d+2)%4;
		int br = r + dr [back];
		int bc = c + dc [back];
		if(br < 0 || bc < 0 || br >= N || bc >= M){
			
		}else if (Map[br][bc] != 1){
			sol(br, bc, d);
		}
				
	}

}
