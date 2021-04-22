//1. The gray code is a binary numeral system where two successive numbers differ in only one bit.
//2. Given a non-negative integer n representing the total number of bits in the code, print the 
//     sequence of gray code. A gray code sequence must begin with 0.

package PepcodingBitManipulation;

import java.util.*;

public class Gray_Code {

   public static List<String> find(int n){
       if(n==1){
           List<String> bres = new ArrayList<>();
           bres.add("0");
           bres.add("1");
           return bres;
       }
       
       List<String> rres = find(n-1);
       List<String> mres = new ArrayList<>();
	    
	    for(int i=0;i<rres.size();i++){
	        String s = rres.get(i);
	        mres.add("0"+s);
	    }
	    for(int i=rres.size()-1;i>=0;i--){
	        String s = rres.get(i);
	        mres.add("1"+s);
	    }
	    
	    return mres;
   }

    public static List<Integer> grayCode(int n) {
	 //Write your code here
	 List<Integer> res=new ArrayList<>();
	 if(n==0){
	     res.add(0);
	     return res;
	 }
	 List<String> solution = find(n);
	 for(String s:solution){
	     res.add(Integer.parseInt(s,2));
	 }
	 
	 return res;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        List<Integer> ans=grayCode(scn.nextInt());
        Collections.sort(ans);
        System.out.println(ans);
    }
}
