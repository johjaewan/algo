package d0126;

import java.util.*;

class Solution {
    boolean[] visited;
    ArrayList<String> path;
    public String[] solution(String[][] tickets) {
        
        String[] answer = {};
        int cnt = 0;
        visited = new boolean[tickets.length];
        path = new ArrayList<>();
        dfs(tickets,"ICN","ICN",cnt);
        
        Collections.sort(path);
        answer = path.get(0).split(" ");
        
        return answer;
    }
    public void dfs( String [][] tickets, String s, String p,int cnt ){
         if(cnt == tickets.length){
            path.add(p);
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(s.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                dfs(tickets, tickets[i][1], p+" "+tickets[i][1], cnt+1);
                visited[i] = false;
            }
        }
    }
}