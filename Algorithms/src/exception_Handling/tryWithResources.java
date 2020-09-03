package exception_Handling;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class tryWithResources {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		//WE CAN USE BUFFERED READER IN TRY SO THAT THEIR IS NO NEED OF CATCH AND FINALLY BLOCK AND IF THEIR EXISTS AN ERROR
		// BR WILL BE DEALOCATED
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			String str="";
			
			str=br.readLine();
	        }
		
		     // OR YOU CAN DO LIKE BELOW METHOD
		
	/*	BufferedReader br=null;
        try {
		String str="";
		br = new BufferedReader(new InputStreamReader(System.in));
		str=br.readLine();
        }
        catch(Exception e) {
        	System.out.println(e);
        }
        finally {
		br.close();
        }
        */
	}

}
