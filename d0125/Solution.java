package d0125;

class Solution {
	   static int answer;
	    
	    public int solution(int[] numbers, int target) {
	        answer = 0;
	       
	           
	        return answer;
	    }
	    static void dfs(int[] numbers, int target, int idx, int res){
	        if(idx == numbers.length){
	            if(res == target){
	                answer++;
	            }
	            return;
	        }
	        dfs(numbers, target, idx+1, res+(-1)*numbers[idx]);
	        dfs(numbers, target, idx+1, res+numbers[idx]);
	    }
	}