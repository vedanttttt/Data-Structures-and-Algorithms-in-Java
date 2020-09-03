package comparablesAndComparators;

public class Student {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "12:40:22AM";
		String[] words = s.split(":");
        int x = Integer.parseInt(words[0]);
        String fs = words[2].substring(0,2);
         String ss = words[2].substring(2,4);
         System.out.println(fs);
         System.out.println(ss);
	}

}
