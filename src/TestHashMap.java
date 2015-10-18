/**
 * @author Christopher Yang <cyang001@citymail.cuny.edu>
 */

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Class that performs jUnit tests for HashMap
 */
public class TestHashMap {
    private HashMap test;

    @Before
    public void beforeEachTest(){
        System.out.println("Starting test: ");
    }


    @After
    public void afterEachTest(){
        System.out.println("OK");
    }

    @AfterClass
    public static void tearDown(){
        System.out.println("All tests finished!");
    }

    @Test
    public void test_set(){
        test = new HashMap(20);
        MapData m = new MapData("Hello World");
        assertTrue(test.set(m.getKey(), m));
    }

    @Test
    public void test_get(){
        test = new HashMap(20);
        MapData m = new MapData("Foo Bar");
        test.set(m.getKey(), m);
        assertEquals(test.get("Foo Bar"), m);
    }

    @Test
    public void test_delete(){
        test = new HashMap(20);
        MapData m = new MapData("Mozzarella Cheese");
        test.set(m.getKey(), m);
        assertEquals(test.delete(m.getKey()), m);
    }

    @Test
    public void test_load(){
        test = new HashMap(20);
        MapData m = new MapData("I like pizza");
        test.set(m.getKey(), m);
        assertEquals(test.load(), (float) 1 / 20, 0);
    }

    @Test
    public void test_full() {

        test = new HashMap(20);
        MapData a = new MapData("Programming");
        MapData b = new MapData("is my");
        MapData c = new MapData("passion!");

        assertTrue(test.set(a.getKey(), a));
        assertTrue(test.set(b.getKey(), b));
        assertTrue(test.set(c.getKey(), c));

        assertEquals(test.load(), 0.15f, 0.0);

        assertEquals(test.get("Not Here"), null);
        assertEquals(test.delete("Neither am I"), null);

        assertEquals(test.get("is my"), b);
        assertEquals(test.delete("is my"), b);

        assertEquals(test.load(), 0.1f, 0.0);
    }

    @Test
    public void test_duplicate() {
        test = new HashMap(20);
        MapData a = new MapData("Duplicate");
        MapData b = new MapData("Duplicate");

        assertTrue(test.set(a.getKey(), a));
        assertFalse(test.set(b.getKey(), b));

        assertEquals(test.load(), 0.05f, 0.0);
    }

}
