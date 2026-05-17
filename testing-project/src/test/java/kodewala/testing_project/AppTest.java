package kodewala.testing_project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
   
    @Test
	public void addTest() {
    	Caluculator e1 = new Caluculator();
    	int excepted = 13;
    	int actual = e1.add(5, 8);
    	
    	assertEquals(excepted, actual);
    }
    
    
}
