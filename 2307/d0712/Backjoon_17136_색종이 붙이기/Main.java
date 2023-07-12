import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int [][] map;
	static int [] jongE_num = {0,5,5,5,5,5};
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		map = new int [10][10];
		
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0,0);
		if(answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(answer);
		}	
	}
	
	public static void dfs(int r, int c, int count) {
		if(r == 9 && c>9) {
			answer = Math.min(answer, count);
			return;
		}
		
		if(count >= answer) {
			return;
		}
		
		if(c > 9) {
			dfs(r+1,0,count);
			return;
		}

		
		if(map[r][c] == 1) {
			for (int i = 5; i >= 1 ; i--) {
				if(jongE_num[i]>0 && flag(r,c,i)) {
					change(r,c,i,0);
					
					jongE_num[i]--;
					
					dfs(r, c + 1, count + 1);
					
					change(r,c,i,1);
					
					jongE_num[i]++;
				}		
			}
		}else {
			dfs(r,c + 1, count);
		}	
	}
	
	public static void change(int r, int c, int size, int state) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				map[i][j] = state;
			}
		}
	}
	
	public static boolean flag(int r, int c, int size) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if(i < 0 || j < 0 || i >= 10 || j >= 10) {
					return false;
				}
				if(map[i][j] != 1) {
					return false;
				}
				
			}
		}
		return true;
	}

}
