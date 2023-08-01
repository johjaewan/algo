import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	static int n, m;
	static int dr []= {-1,0,1,0};
	static int dc []= {0,-1,0,1};
	static int [][] map;
	static boolean[][] visited;
	static ArrayList<Node>[] list;
	static PriorityQueue<Mst> pq;
	static int [] parent;
	
	
	public static class Node {
        int r, c;
 
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
	
	
	public static class Mst implements Comparable<Mst> {
        int n1, n2, length;
 
        public Mst(int n1, int n2, int length) {
            this.n1 = n1;
            this.n2 = n2;
            this.length = length;
        }
 
        @Override
        public int compareTo(Mst mst) {
            return this.length - mst.length;
        }
    }
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int [n][m];
		for(int i = 0; i < n; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		
		list = new ArrayList[7];
		visited = new boolean[n][m];
		int idx = 1;
		for (int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					list[idx] = new ArrayList<>();
					bfs(i,j,idx);
					idx++;
				}
			}	
		}
		
		
		pq = new PriorityQueue<>();
		for(int i = 1; i < idx; i++) {
			for(int j = 0; j < list[i].size(); j++) {
				Node land = list[i].get(j);
				for(int k = 0; k < 4; k++) {
					find(land.r, land.c,i,k,-1);
				}
			}
		}
		
		System.out.println(kruskal(idx));
	}
	public static void bfs(int r, int c, int idx) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r,c));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			map[now.r][now.c] = idx;
			list[idx].add(new Node(now.r, now.c));
			for(int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= n ||nc >= m ) {
					continue;
				}
				if(visited[nr][nc] || map[nr][nc] != 1) {
					continue;
				}
				visited[nr][nc] = true;
				q.add(new Node(nr, nc));
			}
		}
	}
	
	public static void find(int r, int c, int idx, int dir, int len) {
		if(map[r][c] != 0 && map[r][c] != idx) {
			if(len >= 2) {
				pq.add(new Mst(idx, map[r][c], len));
			}
			return;
		}
		
		int nr = r +dr[dir];
		int nc = c +dc[dir];
		if(nr < 0 || nc < 0 || nr >= n || nc >= m) {
			return;
		}
        if(map[nr][nc] == idx) {
        	return;
        }
        find(nr, nc, idx, dir, len + 1);
	}
	
	public static int kruskal(int idx) {
		parent = new int [idx];
		for(int i = 1; i < idx; i++) {
			parent[i] = i;
		}
		
		boolean[] link = new boolean[idx];
		int result = 0;
		int bridge = 0;
		while(!pq.isEmpty()) {
			Mst now = pq.poll();
			
			int p1 = Ufind(now.n1);
			int p2 = Ufind(now.n2);
			
			if(p1 != p2) {
				union(p1, p2);
				link[now.n1] = true;
				link[now.n2] = true;
				result += now.length;
				bridge++;
			}
		}
		if(result == 0) {
			return -1;
		}
		if(bridge != idx -2) {
			return -1;
		}
		return result;
	}
	
	 public static int Ufind(int node) {
	        if(parent[node] == node) {
	        	return node;
	        }
	        else {
	        	return parent[node] = Ufind(parent[node]);
	        }
	    }
	 
	    public static void union(int a, int b) {
	        parent[a] = b;
	    }
}
