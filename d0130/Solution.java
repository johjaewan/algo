package d0130;

import java.util.*;

class Solution {
    static int [] dr = new int []{1,-1,0,0};
    static int [] dc = new int []{0,0,-1,1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        Boolean[][] road = new Boolean[102][102];
        
        characterX *=2;
        characterY *=2;
        itemX *=2;
        itemY *=2;
        
        for(int i = 0; i < rectangle.length; i++) {
            int[] temp = rectangle[i];
            
            for(int j = 0; j < 4; j++) {
                temp[j] *= 2;
            }
            
            for(int x = temp[0]; x <= temp[2]; x++) {
                for(int y = temp[1]; y <= temp[3]; y++) {
                    road[x][y] = (x == temp[0] || x == temp[2] ||
                                     y == temp[1] || y ==temp[3]) && road[x][y] != Boolean.FALSE;   
                }
            }
            
        }
        
        Queue<int[]> queue = new LinkedList<>();
        road[characterX][characterY] = false;
        queue.offer(new int []{characterX, characterY, 0});
        
        int min = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            
            if(now[0] == itemX && now[1] == itemY && min > now[2]) {
                min = now[2];
                continue;
            }
            
            for(int i = 0; i < 4; i++) {
                int x = now[0] + dr[i];
                int y = now[1] + dc[i];
                if(x < 2 || y < 2 || x > 100 || y > 100) {
                    continue;
                }
                if(road[x][y] != Boolean.TRUE) {
                    continue;
                }
                
                road[x][y] = false;
                queue.offer(new int[] {x, y, now[2] + 1});
            }
            
            
        }
        
        return min / 2;
    }
}