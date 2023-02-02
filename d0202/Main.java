package d0202;

import java.util.*;
import java.io.*;


public class Main
{
    public static void main (String args[]) throws IOException
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine());
        int a = 0;
        int b = 0;
        int ans [] = new int [N];
        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(bf.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            ans[i] = a+b; 
        }
        for(int i = 0 ; i<N; i++){
            System.out.println("Case #"+(i+1)+": "+ans[i]);
        }
    }
}