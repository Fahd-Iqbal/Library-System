/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Maximilien Fathi
 */
public class JUnit_testTest {
    
    public JUnit_testTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of testIsbn method, of class JUnit_test.
     */
    @Test
    public void testTestIsbn() {
        System.out.println("testIsbn");
        
        String result = JUnit_test.testIsbn();
        String expResult = result;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of failIsbnTest method, of class JUnit_test.
     */
    @Test
    public void testFailIsbnTest() {
        System.out.println("failIsbnTest");
        JUnit_test instance = new JUnit_test();
        String expResult = "";
        String result = instance.failIsbnTest();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of testId method, of class JUnit_test.
     */
    @Test
    public void testTestId() {
        System.out.println("testId");
        JUnit_test instance = new JUnit_test();
        String expResult = null;
        String result = instance.testId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of testFailId method, of class JUnit_test.
     */
    @Test
    public void testTestFailId() {
        System.out.println("testFailId");
        JUnit_test instance = new JUnit_test();
        String expResult = "";
        String result = instance.testFailId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of testBookList method, of class JUnit_test.
     */
    @Test
    public void testTestBookList() {
        System.out.println("testBookList");
        JUnit_test instance = new JUnit_test();
        String expResult = instance.testBookList();
        String result = instance.testBookList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of failTestBookList method, of class JUnit_test.
     */
    @Test
    public void testFailTestBookList() {
        System.out.println("failTestBookList");
        JUnit_test instance = new JUnit_test();
        String expResult = instance.failTestBookList();
        String result = instance.failTestBookList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateTest method, of class JUnit_test.
     */
    @Test
    public void testUpdateTest() {
        System.out.println("updateTest");
        JUnit_test instance = new JUnit_test();
        boolean expResult = true;
        boolean result = instance.updateTest();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateTestFail method, of class JUnit_test.
     */
    @Test
    public void testUpdateTestFail() {
        System.out.println("updateTestFail");
        JUnit_test instance = new JUnit_test();
        String expResult = instance.updateTestFail();
        String result = instance.updateTestFail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAllTestFail method, of class JUnit_test.
     */
    @Test
    public void testDeleteAllTestFail() {
        System.out.println("deleteAllTestFail");
        JUnit_test instance = new JUnit_test();
        boolean expResult = false;
        boolean result = instance.deleteAllTestFail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRow method, of class JUnit_test.
     */
    @Test
    public void testDeleteRow() {
        System.out.println("deleteRow");
        JUnit_test instance = new JUnit_test();
        boolean expResult = true;
        boolean result = instance.deleteRow();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCon method, of class JUnit_test.
     */
//    @Test
//    public void testSetCon() {
//        System.out.println("setCon");
//        JUnit_test instance = new JUnit_test();
//        Connection expResult = instance.;
//        Connection result = instance.setCon();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
    
}
