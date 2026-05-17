package execptionexamples;

public class ArthematicExecption {

	public static void main(String[] args) {
		int i = 10;
		
			try {
				int result = i/0;
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		System.out.println("end of progrm");
	}
}
