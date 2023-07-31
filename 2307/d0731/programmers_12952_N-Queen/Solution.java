import java.util.*;

class Solution {
    static int map[];
    static int N;
    static int cnt;
    
    public int solution(int n) {
        int answer = 0;
        N = n;
        map = new int [N];
        dfs(0);
        answer = cnt;
        return answer;
    }
    
    public static void dfs(int depth){
        if(depth == N){
            cnt++;
            return;
        }
        
        for(int i = 0; i < N; i++){
            map[depth] = i; // 퀸의 행 인덱스 = depth, 퀸의 열인덱스 = i; 같은 행에는 하나만 올 수 있다는 특성 때문에
            // 행의 인덱스를 dfs의 depth로 정함
            
            if(avail(depth)){// 현위치에 퀸을 배치 가능하다면
                dfs(depth+1);// 다음행에서 퀸 위치 정하기 진행
            }     
        }
    }
    
    public static boolean avail(int depth){
        for(int i = 0; i < depth; i++){//현재 depth 까지 진행되는 동안 저장된 퀸의 위치를 반복문으로 탐색
            if(map[i] == map[depth]){//같은 열에 퀸이 있는지 판단
                return false;
            }
            if((depth-i) == Math.abs(map[depth] - map[i])){//같은 대각선에 퀸이 있는지 판단
                return false;
            }
        }
        return true;
    }
}