package test;

import jUnitProgram.Check;
import jUnitProgram.LoadModule;
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
     *@Test class Check
     */
    public void testCheck() {
        Check ch = new Check();
        String [] str = {"one.jar"};
    	assertTrue(ch.checking(str));
    }
    
    /**
     *@Test Class LoadModule
     */
    public void testStripClassName() {
    	LoadModule load = new LoadModule("Заглушка");
    	String str = load.stripClassName("simple.class");
    	assertTrue(str.equals("simple"));
    }
}
