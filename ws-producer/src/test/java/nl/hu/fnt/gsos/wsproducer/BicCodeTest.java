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
public class BicCodeTest extends TestCase {
    
    public BicCodeTest(String testName) {
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
     * Test of getBankCode method, of class BicCode.
     */
    public void testGetBankCode() {
        System.out.println("getBankCode");
        BicCode instance = new BicCode("ABNANL2A");
        String expResult = "ABNA";
        String result = instance.getBankCode();
        assertEquals(expResult, result);
        if(!result.equals(expResult))
            fail("Het juiste resultaat komt niet terug - getBankCode");
    }

    /**
     * Test of fail getBankCode method, of class BicCode.
     */
    public void testGetBankCodeFail() {
        System.out.println("getBankCodeFail");
        BicCode instance = new BicCode("ABNANL2B");
        String expResult = "false";
        String result = instance.getBankCode();
        assertEquals(expResult, result);
        if(!result.equals(expResult))
            fail("Het juiste resultaat komt niet terug - getBankCodeFail");
    }
    
}
