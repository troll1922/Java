package test;

import java.math.BigInteger;

import factorial.Factorial;
import junit.framework.TestCase;

/**
 * Юнит тест для приложения
 */
public class AppTest extends TestCase {
	/**
     * Конструткор теста, в котором можно задать имя теста
     */
    public AppTest( String testName ) {
        super( testName );
    }

    /**
     * 
     *@Test class Factorial
     */
    public void testCheck() {
        Factorial factorial = new Factorial();
        BigInteger result = factorial.getSolve(7);
    	assertTrue(result.equals(BigInteger.valueOf(5040)));
    }
}
