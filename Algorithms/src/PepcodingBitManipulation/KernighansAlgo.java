//1. You are given a number n.
//2. You have to count the number of set bits in the given number.

package PepcodingBitManipulation;

import java.io.*;
import java.util.*;

public class KernighansAlgo {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    int count = 0;
    while(n>0){
        int rsbm = n & -n;
        count++;
        n = n - rsbm;
    }
    
    System.out.println(count);
    
    //write your code here
  }

}
