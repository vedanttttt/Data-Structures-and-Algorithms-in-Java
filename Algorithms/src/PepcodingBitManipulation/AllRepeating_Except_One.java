//
//1. You are given an array of numbers.
//2. All numbers occur twice in the array except one.
//3. You have to find that number by traversing only once in the array and without using any extra 
//     space.

package PepcodingBitManipulation;

import java.io.*;
import java.util.*;

public class AllRepeating_Except_One {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < n; i++){
      arr[i] = scn.nextInt();
    }
    
    int xor = 0;
    for(int e:arr){
        xor ^= e;
    }
    System.out.println(xor);
    //write your code here
    
  }

}
