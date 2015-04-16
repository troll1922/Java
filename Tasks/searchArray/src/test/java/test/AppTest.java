package test;

import searchArray.SearchArray;
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
     *@Test class SearchArray
     */
    public void testCheck() {
        SearchArray obj = new SearchArray();
        int[] array = {0, 2, 3, 5, 6, 7}; //пропущены 1 и 4
        obj.setArray(array);
        obj.scan(); //обрабатываем массив и заносим пропущенные числа в поля объекта
        boolean bool;
        if ((obj.getOne()==1)&&(obj.getTwo()==4)) bool = true;
        else bool = false;
    	assertTrue(bool);
    }
}
