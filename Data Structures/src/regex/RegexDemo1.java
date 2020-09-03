package regex;
import java.util.Scanner;
import java.util.regex.*;

public class RegexDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
		
		Pattern pattern = Pattern.compile(".r");
		Matcher m = pattern.matcher("br");
		
		boolean result = m.matches();
		//System.out.println(result);
		
		boolean res = Pattern.compile(".r").matcher("br").matches();
	//	System.out.println(res);
		
		boolean q = Pattern.matches("\\s","[^\\S]");
		//System.out.println(q);
		
	//	System.out.println(Pattern.matches("^this","this is text"));
		
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
				
		//System.out.println(s.matches("\\d\\d\\d([-]){1}\\d\\d\\d([-])\\d\\d\\d\\d"));
	//	System.out.println(s.matches("^[^\\d].*abc.*{3}"));
		//System.out.println(s.matches(".*{3}"));
		System.out.println(s.matches("^(\\d{3}-\\d{2}-\\d{4})"));
	}

}
