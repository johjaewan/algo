import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int time = 0;
        int W = 0;
        
        Queue<Integer> q = new LinkedList<>();
        for(int truck : truck_weights){
            while(true){
                if(q.isEmpty()){
                    q.add(truck);
                    time++;
                    W += truck;
                    break;
                }else if(q.size() == bridge_length){
                     W -= q.poll();
                }else{
                    if(W + truck > weight){
                        q.add(0);
                        time++;
                    }else{
                        q.add(truck);
                        time++;
                        W += truck;
                        break;
                    }
                }
            }
        }
        answer = time + bridge_length;
        return answer;
    }
}