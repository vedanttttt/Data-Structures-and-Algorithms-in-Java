//1. You are given an array of numbers.
//2. All numbers occur thrice in the array except one.
//3. You have to find the element that occurs once.

package PepcodingBitManipulation;

import java.io.*;
import java.util.*;

public class AllRepeatingThreeTime_Except_One {

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
   int tn=Integer.MAX_VALUE; // 3n
   int tnp1 = 0;
   int tnp2 = 0;
   
   for(int i=0;i<arr.length;i++){
       int cwtn = tn & arr[i]; //common with 3n
       int cwtnp1 = tnp1 & arr[i];
       int cwtnp2 = tnp2 & arr[i];
       
       tn = tn & (~cwtn);
       tnp1 = tnp1 | cwtn;
       
       tnp1 = tnp1 & (~cwtnp1);
       tnp2 = tnp2 | cwtnp1;
       
       tnp2 = tnp2 & (~cwtnp2);
       tn = tn | cwtnp2;
   }
   
   System.out.println(tnp1);
   
  }

}
