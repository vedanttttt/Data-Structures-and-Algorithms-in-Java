package regex;

import java.util.Scanner;
import java.util.regex.*;
public class Demo {

	public static void main(String args[]) {
		
		try(Scanner sc = new Scanner(System.in)) {
			
			while(true) {
				System.out.println("Enter regex pattern:");
				String regexPattern = sc.nextLine();
				Pattern pattern = Pattern.compile(regexPattern);
				Matcher matcher = pattern.matcher("Welcome to Edureka YouTube channel");
				boolean found = false;
				while(matcher.find()) {
					System.out.println("found the text "
							+ matcher.group()+ " starting at index"
							+ matcher.start()
							+ " and ending at index"
							+ matcher.end());
					found=true;
				}if(!found) {
					System.out.println("Match not found");
				}
			}
		}
	}
}
