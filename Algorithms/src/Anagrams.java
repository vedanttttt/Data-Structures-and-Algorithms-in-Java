
public class Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 String a = "aat";
		 String b = "taa";
		 boolean isanagram=true;
		/* boolean[] visited = new boolean[b.length()];
		 
		 if(a.length() == b.length()) { 
		 for(int i=0;i<a.length();i++) {
			 char c = a.charAt(i);
			 isanagram=false;
			 for(int j=0;j<b.length();j++) {
               if(c==b.charAt(j) && !visited[j]) {
            	   visited[j]=true;
            	   isanagram=true;
            	   break;
               }
			 }
			 if(!isanagram)
				 break;
		 }
		 }*/
		 
		 int[] al = new int[256];
		// int[] bl = new int[256];
		 
		 for(char c: a.toCharArray()) {
			 int index = (int)c;
			 al[index]++;
		 }
		 for(char c: b.toCharArray()) {
			 int index = (int)c;
			 al[index]--;
		 }
		 
		 for(int i=0;i<256;i++) {
           if(al[i] != 0) {
        	   isanagram=false;
        	   break;
           }
		 }
		 
		 System.out.println(isanagram);
	}

}
