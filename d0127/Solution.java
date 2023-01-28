package d0127;

import java.util.*;

class Solution {
    static int diffnum(String word, String now){
        char[] wordArr = word.toCharArray();
        char[] nowArr = now.toCharArray();
        int cnt = 0;
        for(int i = 0; i < wordArr.length; i++){
            if(wordArr[i] != nowArr[i]){
                cnt++;
            }
        }
        return cnt;
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int N = words.length;
        int [] visited = new int [N]; 
        
        boolean flag = false;
        
        for(int i = 0; i < N; i++){
            if(target.equals(words[i])){
                flag = true;
            }
        }
        
        if(!flag){
            return 0;
        }
        
       
        Queue <String> q = new LinkedList<>();
        q.add(begin);
        
        int level = 0;
        Loop :
        while(!q.isEmpty()){
            int size = q.size();
            
            
            for(int i = 0 ; i < size; i++){
                String now = q.poll();
                
                if(now.equals(target)){
                    break Loop;
                }
                
                for(int j = 0 ; j < N; j++){
                   
                    if(diffnum(words[j], now) == 1 && visited[j] == 0){
                        
                        visited[j] = 1;
                        q.add(words[j]);
                    }       
                }   
            }level++;
        }
        answer = level;
        return answer;
    }
}