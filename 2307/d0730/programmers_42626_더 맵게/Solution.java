import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i : scoville){
            pq.add(i);
        }
        
        while(pq.peek()<K){
            int temp = pq.poll() + pq.poll()*2;
            pq.add(temp);
            answer++;
            
            if(pq.size() == 1 && pq.peek() < K){
                answer = -1;
                break;
            }           
        }
        return answer;
    }
}