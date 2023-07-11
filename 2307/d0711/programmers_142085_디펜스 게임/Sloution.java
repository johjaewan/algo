import java.util.Arrays;

class Solution {
    
    static int N,K;
    static int[] Enemy;
    
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        N = n;
        K = k;
        Enemy = enemy;

        answer = BS();
        return answer;
    }
    
    
    public static int BS(){
        int low = 0;
        int high = Enemy.length;
        
        while(low < high){
            int mid = (low + high) / 2;
            
            if(flag(mid)){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }
    
    public static boolean flag (int mid){
        int temp [] = Arrays.copyOfRange(Enemy, 0, mid+1);
        Arrays.sort(temp);
        int n = N;
        for (int i = 0; i < mid + 1; i++){
            int val = temp[i];
            if(val <= n){
                n -= val;
                continue;
            }
            return K >= mid + 1 - i;
        }
        return true;
    }
    
}