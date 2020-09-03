import java.io.*;
import java.util.*;

public class Solution {
    private int length;
    private ListNode top;

    private class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
          this.data=data;
          this.next=null;
        }
    }
     public Solution(){
         this.length=0;
         this.top=null;
     }

      public Boolean isEmpty(){
       return length==0;
      }

      public void push(int data){
        ListNode x = new ListNode(data);
          x.next=top;
          top=x;
          length++;
      }
      
      public void pop(){
          if(isEmpty()){
            }
         //int result = top.data;
          top=top.next;
          length--;
          
      }
    
      public void max(){
          if(isEmpty()){
        
          }
          long max=Integer.MIN_VALUE;
          while(top!=null){
              if(top.data>max){
                  max=top.data;
              }
              top=top.next;
          }
          System.out.println(max);
      }  

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Solution stack = new Solution();
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        for(int i=0;i<k;i++){
           int l = sc.nextInt();
           if(l==1){
               int m = sc.nextInt();
               stack.push(m);
           }
           if(l==2){
               stack.pop();
           }
           if(l==3){
               stack.max();
           }
        }
    }
}
