import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i< words.length; i++){
            if(i != 0){//0일 때는 생략
                String last = words[i-1];
                String now = words[i];
                
                if(map.containsKey(now) || last.charAt(last.length()-1) != now.charAt(0)){
                    answer[0] = (i%n)+1;
                    answer[1] = (i/n)+1;
                    
                    return answer;
                }
            }
            
            map.put(words[i],1);
        }
        

        return answer;
    }
}