import java.util.*;

class Solution {
    static Stack<Work> stack;
    static String[][] P;
    static List<String> result;
    static List<Work> list;
    
    class Work{
        String name;
        int start, runtime;
        
        public Work(String name, int start, int runtime){
            this.name = name;
            this.start = start;
            this.runtime = runtime;
        }
    }
    public String[] solution(String[][] plans) {
        String[] answer = {};
        result = new ArrayList<>();
        stack = new Stack<>();
        list = new LinkedList<>();
        // 과제 시간별로 소팅
        Arrays.sort(plans, new Comparator<String[]>(){
            @Override
            public int compare(String[] o1, String[] o2){
                int timeO1 = Integer.parseInt(o1[1].split(":")[0] + o1[1].split(":")[1]);
                int timeO2 = Integer.parseInt(o2[1].split(":")[0] + o2[1].split(":")[1]);
            return timeO1-timeO2;
            }
        });
        for(String[] work : plans){
            int startTime = Integer.parseInt(work[1].split(":")[0])*60 + Integer.parseInt(work[1].split(":")[1]);
            list.add(new Work(work[0],startTime,Integer.parseInt(work[2])));
        }
                     
        int idx = 0;
        P = plans;
        process(list.get(idx), idx, list.get(idx).start);
        // 하나씩 꺼내서 수행하기
            // 꺼낸 후에 종료시간 확인
            // 다음 꺼 시작 시간 체크
            // 다음꺼 시작 시간이 종료시간보다 전이거나 같다
                // 지금 꺼는 스택에 넣기
                // 다음 꺼 실행
            // 다음꺼 시작 시간이 종료 시간보다 후다
                // 종료되었으니 현재꺼 answer에 넣기
                // 스택에 남은게 있다면 실행 //인덱스와 문자열을 인자로 받아서 넣어야 할듯
                // 없다면 다음꺼 실행     
        answer = result.toArray(new String[0]);
        return answer;
    }
    public static void process(Work now, int idx, int rightnow){// 실행되고 있는 과제, 과제의 인덱스, 현재 시간
        //마지막 인덱스에서 예외처리
        if(idx == P.length - 1){
            result.add(now.name);// 마지막 과제 끝내고
            while(!stack.empty()){// 남은 중단된 과제도 순서대로 끝냄
                result.add(stack.pop().name); 
            }
            return;
        }
        
        int min, hour, endTime, nextStartTime;
        
        // 꺼낸 후에 종료시간 확인
        // 다음 꺼 시작 시간 체크
       
        endTime = rightnow + now.runtime;// 지금 과제의 종료 시간
        nextStartTime = list.get(idx+1).start;// 다음 과제의 시작 시간
        
        if(endTime > nextStartTime){// 다음 과제의 시작 시간이 지금 과제의 종료 시간보다 전이다.
            now.runtime = endTime - nextStartTime;//이미 실행된 시간을 반영
            stack.push(now);// 지금 과제는 스택에 넣기
            process(list.get(idx + 1), idx + 1, nextStartTime);// 다음 과제 실행
        }else if(endTime == nextStartTime){
            result.add(now.name);// 지금 과제는 끝남
            process(list.get(idx + 1), idx + 1, nextStartTime);// 다음 과제 실행
        }else{//다음 과제의 시작 시간이 지금 과제의 종료 시간보다 후다 
            result.add(now.name);// 지금 과제는 끝남
            if(!stack.empty()){// 스텍에 중단된 과제 있는지 확인
                process(stack.pop(), idx, endTime);// 있으면 실행  
            }else{// 없으면 다음꺼 실행
                process(list.get(idx + 1), idx + 1, nextStartTime);
            }
        }  
    }
    
}