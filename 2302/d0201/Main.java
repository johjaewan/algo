package d0201;

import java.util.*;
import java.io.*;

class stone implements Comparable {
	int weight;
	int price;

	stone (int weight, int price) {
		this.weight = weight;
		this.price = price;
	}

	@Override	
	public int compareTo(Object o) {
		stone other = (stone) o;	
		return other.price - this.price;
	}
}
public class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int W= sc.nextInt();
        int N= sc.nextInt();
        int [] table = new int [10000];
        List<stone> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            stone tstone = new stone(sc.nextInt(), sc.nextInt());
            list.add(tstone);
            int k =tstone.price-1;
            table[k] =table[k]+ tstone.weight;
        }

        int bagW = 0;
        int bagp = 0;
        for(int i = 10000-1; i>=0; i--){
            if(table[i] == 0){continue;}
            if(bagW + table[i] <= W){
                bagW += table[i];
                bagp += table[i]*(i+1);
            }else{
                bagp += (W-bagW)*(i+1);
                break;
            }
        }
        
        System.out.println(bagp);
    }
}