package exception_Handling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class checkedException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i=8,j,k=0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			j=Integer.parseInt(br.readLine());
			k=i/j;
			System.out.println(k);
			if(k>3) {
				throw new IOException();
			}
		}
		catch(IOException e) {
			System.out.println("Some input-output error");
		}
		/*catch(Exception e) {
			System.out.println("Brohh");
		}*/
		finally {
			System.out.println("Final Bye");
		}
	}

}
