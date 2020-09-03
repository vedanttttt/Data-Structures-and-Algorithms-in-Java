package regex;

import java.util.regex.*;

public class RegexExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Pattern pattern = Pattern.compile(".xx.");
      Matcher matcher = pattern.matcher(" xxB");
      System.out.println("String matches the given regex "+ matcher.matches());
     // System.out.println(Pattern.matches("[xyz]","wbcd"));
    //  System.out.println(Pattern.matches("[xyz]","x"));
    //  System.out.println(Pattern.matches("[xyz]","xxyyyyyz"));
      System.out.println(Pattern.matches("[ayz]?","a"));
      System.out.println(Pattern.matches("[xyz]?","a"));
      System.out.println(Pattern.matches("[xyz]?","a"));
      System.out.println(Pattern.matches("[xyz]?","a"));
      
	}

}
