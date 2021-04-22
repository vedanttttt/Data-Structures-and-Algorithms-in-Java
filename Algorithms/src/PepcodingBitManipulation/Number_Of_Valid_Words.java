package PepcodingBitManipulation;

import java.io.*;
import java.util.*;

public class Number_Of_Valid_Words {

	public static ArrayList<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
		//write your code here
		ArrayList<Integer> res = new ArrayList<>();
		
		Map<Character,List<Integer>> map = new HashMap<>();
		for(int i=0;i<26;i++){
		    map.put((char)('a'+i),new ArrayList<>());
		}
		
		for(String word:words){
		    int mask=0;
		    for(char c : word.toCharArray()){
		        int i = c-'a';
		        mask = mask | (1<<i);
		    }
		    Set<Character> set = new HashSet<>();
		    for(char c:word.toCharArray()){
		        if(set.contains(c))
		        continue;
		        set.add(c);
		        map.get(c).add(mask);
		    }
		}
		
		for(String puzzle:puzzles){
		    int mask=0;
		    for(char c : puzzle.toCharArray()){
		        int i = c-'a';
		        mask = mask | (1<<i);
		    }
		    
		    int count=0;
		    List<Integer> toCompare = map.get(puzzle.charAt(0));
		    for(int e:toCompare){
		        if((e & mask)==e)
		        count++;
		    }
		    res.add(count);
		}
		
		return res;
	 }

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		String[] words = new String[n];
		for(int i = 0 ; i < words.length; i++) {
			words[i] = scn.next();
		}
		int m = scn.nextInt();
		String[] puzzles = new String[m];
		for(int i = 0 ; i < m ;i++) {
			puzzles[i] = scn.next();
		}
		ArrayList<Integer> ans = findNumOfValidWords(words,puzzles);
		for(int i=0;i<ans.size();i++) {
			System.out.println(puzzles[i] + " -> " + ans.get(i));
		}
	}
	
}