package exception_Handling;

public class demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i,j,k=0;
		i=2;
		j=0;
		try {
			k=i/j;
		}
		catch(Exception e) {
			System.out.println("Brohh");
		}
		System.out.println(k);
	}

}
