package exception_Handling;

public class userDefinedException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i=5;
		try {
		if(i<10) {
			throw new meraException("Errorbhaiya");
		}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}

class meraException extends Exception{
	
	public meraException(String s) {
		super(s);
		//System.out.println("aya"+s);
	}
}