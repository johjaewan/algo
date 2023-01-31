package d0131;

public class Solution {
	
	static int visited[];

	public int solution(int n, int[][] computers) {
		int answer = 0;
		
		visited = new int [n];
		
		for (int i = 0; i<n; i++) {
			if(visited[i] == 0) {
				answer++;
				dfs(i, computers,n);
			}
		}
		System.out.println(syso);
		return answer;
	}
	
	static void dfs (int i, int computers[][], int n) {
		visited[i] = 1;
		for(int j = 0; j < n; j++) {
			if(visited[j] == 0 && computers [i][j] == 1) {
				dfs(j,computers,n);
			}
		}
	}

}
