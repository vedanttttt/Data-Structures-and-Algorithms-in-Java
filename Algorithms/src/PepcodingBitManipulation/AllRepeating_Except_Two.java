//1. You are given an array of numbers.
//2. You have to find 2 non-repeating numbers in an array.
//3. All repeating numbers are repeating even number of times.

package PepcodingBitManipulation;

import java.io.*;
import java.util.*;

public class AllRepeating_Except_Two {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < n; i++){
      arr[i] = scn.nextInt();
    }
    solution(arr);
  }

  public static void solution(int[] arr){
   //write your code here
   int xxory = 0;
   for(int val:arr){
       xxory ^= val;
   }
   
   int rsbm = xxory & -xxory;
   
   int x=0,y=0;
   for(int e:arr){
       if((e & rsbm)==0){
           y ^= e;
       }
       else{
           x ^= e;
       }
   }
   
   System.out.print((x<y) ? (x + "
" + y) : (y + "
" + x));
  }

}
