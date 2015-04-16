package test;

import validation.Validation;
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
     *@Test class Validation
     */
    public void testCheck() {
        Validation valid = new Validation();
        boolean bool = valid.getSolve("()()())(())(()");
    	assertFalse(bool);
    }
}
