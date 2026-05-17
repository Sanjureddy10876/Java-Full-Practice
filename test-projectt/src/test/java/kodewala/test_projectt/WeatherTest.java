package kodewala.test_projectt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class WeatherTest 
{
	  @Test
		public void addTest() {
	    	Weather e1 = new Weather();
	    	int excepted = 13;
	    	int actual = e1.add(5, 8);
	    	assertEquals(excepted, actual);
	    }
	  
	  @Test
	  public void mutiplee() {
		  Weather w1 = new Weather();
		  int expected = 10;
		  int actuval = w1.add(5, 5);	
		  assertEquals(expected, actuval);
	  }
	  @Test
	  public void addtestt() {
		  Weather w2 = new Weather();
		  int expected = 600;
		  int actuval = w2.add(300, 400);
		  assertEquals(expected, actuval);
	  }
	  
}
