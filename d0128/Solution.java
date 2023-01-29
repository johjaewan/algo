package d0128;

import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int tn = t.length(); 
        int pn = p.length();
        long num_p = Long.parseLong(p); 
        
        for(int i = 0; i <tn - pn + 1; i++){
            long num_sub =Long.parseLong(t.substring(i,i+pn));
            if(num_sub <= num_p) {
                answer++;
            }
        }
        return answer;
    }
}
