package d0213;

import java.util.*;

public class Solution {
    static int Map[][];
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        Map = new int [m][n];
        int [][] check = new int [m][n];
        
        
        for(int i = 0; i <m; i++){
            for(int j = 0; j < n; j++){
                Map [i][j] = board[i].charAt(j);
            }
        }
        
        boolean flag = true;
        while(flag){
            check = new int [m][n];
            flag = false;
            for(int i = 0; i <m-1; i++){
                for(int j = 0; j < n-1; j++){
                    if(Map[i][j] == 0){
                        continue;
                    }
                    if(isfour(i,j)){
                        check[i][j] = 1;
                        check[i][j+1] = 1;
                        check[i+1][j+1] = 1;
                        check[i+1][j] = 1;
                        flag = true;
                    }
                }
            }
            
            
            for(int i = 0; i <m; i++){
                for(int j = 0; j < n; j++){
                    if(check[i][j] == 1){
                        Map[i][j] = 0;
                        answer++;
                    }
                }
            }
            
            for(int j = 0; j<n; j++){
                Queue<Integer> q = new LinkedList<>();
                for(int i = m-1; i>=0; i--){
                    if(Map[i][j] != 0){
                        q.add(Map[i][j]);
                    }
                }
                int idx = m-1;
                while(!q.isEmpty()){
                    Map[idx][j]=q.poll();
                    idx--;
                }
                for(int i=idx; i>=0; i--){
                    Map[i][j] = 0;
                }
            } 
        }
        return answer;
    }
    
    public static boolean isfour(int r, int c){
        int t = Map[r][c];
        if(t == Map[r][c+1] && t == Map[r+1][c] && t == Map[r+1][c+1]){
            return true;
        }
        return false;
    }
}