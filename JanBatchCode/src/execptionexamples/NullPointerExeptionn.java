package execptionexamples;

public class NullPointerExeptionn {
	public static void main(String[] args) {
		
		System.out.println("start of code");
		String str = null;
		
		try {
			System.out.println(str.length());
			System.out.println("testing after exepection occurs");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("end of code");
		
	}

}
