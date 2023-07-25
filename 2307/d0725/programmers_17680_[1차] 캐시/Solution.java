import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize == 0) {
            return cities.length * 5;
        }
           
        
        ArrayList <String> q = new ArrayList<>();
        //Queue <String> q = new LinkedList<>();//1,3,4 테케 불통
        for(int i = 0; i <cities.length; i++){
            String s = cities[i].toUpperCase();
            if(q.contains(s)){
                q.remove(s);
                q.add(s);
                answer ++;
            }else{
                if(q.size() == cacheSize){
                    q.remove(0);
                    q.add(s);
                }else{
                    q.add(s);
                }
                answer += 5;
            }
        }
        return answer;
    }
}