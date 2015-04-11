/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hu.fnt.gsos.wsproducer;

import junit.framework.TestCase;

/**
 *
 * @author Jelle
 */
public class ClassicAccountTest extends TestCase {
    
    public ClassicAccountTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of isCorrectAccountNumber method, of class ClassicAccount.
     */
    public void testIsCorrectAccountNumber() {
        System.out.println("isCorrectAccountNumber");
        ClassicAccount instance = new ClassicAccount(123456789);
        boolean expResult = true;
        boolean result = instance.isCorrectAccountNumber();
        assertEquals(expResult, result);
        if(result != expResult)
            fail("Het juiste resultaat komt niet terug - isCorrectAccountNumber");
    }

    /**
     * Test of fail isCorrectAccountNumber method, of class ClassicAccount.
     */
    public void testIsCorrectAccountNumberFail() {
        System.out.println("isCorrectAccountNumberFail");
        ClassicAccount instance = new ClassicAccount(123456782);
        boolean expResult = false;
        boolean result = instance.isCorrectAccountNumber();
        assertEquals(expResult, result);
        if(result != expResult)
            fail("Het juiste resultaat komt niet terug - isCorrectAccountNumberFail");
    }
    
}
