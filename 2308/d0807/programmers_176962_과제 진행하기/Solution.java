import java.util.*;

class Solution {
    static Stack<String []> stack;
    static String[][] P;
    static List<String> result;
    public String[] solution(String[][] plans) {
        String[] answer = {};
        result = new ArrayList<>();
        // 과제 시간별로 소팅
        Arrays.sort(plans, new Comparator<String[]>(){
            @Override
            public int compare(String[] o1, String[] o2){
                int timeO1 = Integer.parseInt(o1[1].split(":")[0] + o1[1].split(":")[1]);
                int timeO2 = Integer.parseInt(o2[1].split(":")[0] + o2[1].split(":")[1]);
            return timeO1-timeO2;
            }
        });
        int idx = 0;
        P = plans;
        process(plans[0], idx , 0);
        // 하나씩 꺼내서 수행하기
            // 꺼낸 후에 종료시간 확인
            // 다음 꺼 시작 시간 체크
            // 다음꺼 시작 시간이 종료시간보다 전이거나 같다
                // 지금 꺼는 스택에 넣기
                // 다음 꺼 실행
            // 다음꺼 시작 시간이 종료 시간보다 후다
                // 종료되었으니 현재꺼 answer에 넣기
                // 스택에 남은게 있다면 실행 //인덱스와 문자열을 인자로 받아서 넣어야 할듯
        for(String[] temp : plans){
            System.out.println(temp[0] + " " + temp[1]);
        }        
        answer = result.toArray(new String[0]);
        return answer;
    }
    public static void process(String[] now, int idx, int flag){
        if(idx == P.length - 1){
            result.add(now[1]);
            while(!stack.empty()){
                result.add(stack.pop()[0]); 
            }
            return;
        }
        
        int min, hour, endTime, nextStartTime;
        
        if(flag == 0){
            min = Integer.parseInt(now[1].split(":")[1]) + Integer.parseInt(now[2]);
            hour = min/60;
            min = min % 60;
            endTime = (Integer.parseInt(now[1].split(":")[0]) + hour)*100 + min;
            nextStartTime = Integer.parseInt(P[idx+1][1].split(":")[0] + P[idx+1][1].split(":")[1]);
        }else{
            min = Integer.parseInt(P[idx][1].split(":")[1]) + Integer.parseInt(now[2]);// 실행시간 빼주자
            hour = min/60;
            min = min % 60;
            endTime = (Integer.parseInt(P[idx][1].split(":")[0]) +hour)*100 + min;
            nextStartTime = Integer.parseInt(P[idx+1][1].split(":")[0] + P[idx+1][1].split(":")[1]);
        }
        if(endTime > nextStartTime){
            now[2] = String.valueOf(endTime - nextStartTime);
            stack.push(now);
            process(P[idx + 1], idx + 1, 0);
        }else if(endTime == nextStartTime){
            process(P[idx + 1], idx + 1, 0);
        }else{
            result.add(now[0]);
            if(!stack.empty()){
                process(stack.pop(), idx, 1);  
            }
        }
        
    }
}