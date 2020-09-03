package Strings;

public class ReverseAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s="deepak";
		StringBuffer sb = new StringBuffer(s);
		//System.out.println(sb.reverse());
		String s1="";
		for(int i=s.length()-1;i>=0;i--) {
			s1 +=s.charAt(i);
		}
		System.out.println(s1);
	}

}
