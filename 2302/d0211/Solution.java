package d0211;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    static class File{
        String name;
        String head;
        int num;
        
        public File(String name, String head, int num){
            this.name = name;
            this.head = head;
            this.num = num;
            
        }
    }
    
    public String[] solution(String[] files) {
        File [] fileArr = new File[files.length];
        
        
        for (int i = 0; i < files.length; i++) {
            String[] split = detach(files[i]);
            fileArr[i] = new File(files[i], split[0], Integer.parseInt(split[1]));
        }
        Arrays.sort(fileArr, new Comparator<File>(){
        	@Override
            public int compare(File o1,File o2){
                if((o1.head).equals(o2.head)){
                    return o1.num-o2.num;
                }
                else{
                    return(o1.head).compareTo(o2.head);
                }
            }
        });
        
        String[] answer = new String[files.length];
        for(int i = 0; i < files.length; i++){
            answer[i] = fileArr[i].name;
        }
        return answer;
    }
    
    public static String[] detach (String str){
        String s[] = new String[3];
        s[0] = ""; 
        s[1] = ""; 
        s[2] = ""; 

        int idx = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(idx==0 && !Character.isDigit(c)){
                s[idx] += c;
                continue;
            }

            if(idx==0 && Character.isDigit(c)){
                idx ++;
            }

            if(idx==1 && Character.isDigit(c)){
                s[idx] += c;
                continue;
            }

            if(idx==1 && !Character.isDigit(c)){
                idx ++;
            }
            s[idx] += c;
        }

        s[0] = s[0].toLowerCase();
        
        return s;
    }
}

