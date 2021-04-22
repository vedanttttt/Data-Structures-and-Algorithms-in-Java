//1. You are given a number n.
//2. You have to print the right-most set bit mask.

package PepcodingBitManipulation;

import java.io.*;
import java.util.*;

public class PrintValueOfRsbMask {

	  public static void main(String[] args){
	    Scanner scn = new Scanner(System.in);
	    int n = scn.nextInt();
	    
	    int rsbm = n & -n;
	    System.out.println(Integer.toBinaryString(rsbm));

	    //write your code here
	  }

	}
