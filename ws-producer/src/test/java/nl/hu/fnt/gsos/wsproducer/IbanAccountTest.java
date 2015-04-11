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
public class IbanAccountTest extends TestCase {
    
    public IbanAccountTest(String testName) {
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
     * Test of generateInteger method, of class IbanAccount.
     */
    public void testGenerateInteger() {
        System.out.println("generateInteger");
        String bankAccount = "NL55VOWA0123456789";
        IbanAccount instance = new IbanAccount(bankAccount.substring(4, 8), bankAccount.substring(8), bankAccount.substring(2, 4), bankAccount.substring(0, 2));
        String expResult = "312432100123456789232155";
        String result = instance.generateInteger();
        assertEquals(expResult, result);
        if(!result.equals(expResult))
            fail("Het juiste resultaat komt niet terug - generateInteger");
    }

    /**
     * Test of generateIban method, of class IbanAccount.
     */
    public void testGenerateIban() {
        System.out.println("generateIban");
        String bankAccount = "NL00VOWA0123456789";
        IbanAccount instance = new IbanAccount(bankAccount.substring(4, 8), bankAccount.substring(8), bankAccount.substring(2, 4), bankAccount.substring(0, 2));
        String expResult = "NL55VOWA0123456789";
        String result = instance.generateIban();
        assertEquals(expResult, result);
        if(!result.equals(expResult))
            fail("Het juiste resultaat komt niet terug - generateIban");
    }

    /**
     * Test of validateIban method, of class IbanAccount.
     */
    public void testValidateIban() {
        System.out.println("validateIban");
        String bankAccount = "NL55VOWA0123456789";
        IbanAccount instance = new IbanAccount(bankAccount.substring(4, 8), bankAccount.substring(8), bankAccount.substring(2, 4), bankAccount.substring(0, 2));
        boolean expResult = true;
        boolean result = instance.validateIban();
        assertEquals(expResult, result);
        if(result != expResult)
            fail("Het juiste resultaat komt niet terug - validateIban");
    }

    /**
     * Test of fail validateIban method, of class IbanAccount.
     */
    public void testValidateIbanFail() {
        System.out.println("validateIbanFail");
        String bankAccount = "NL55VOWA0123456782";
        IbanAccount instance = new IbanAccount(bankAccount.substring(4, 8), bankAccount.substring(8), bankAccount.substring(2, 4), bankAccount.substring(0, 2));;
        boolean expResult = false;
        boolean result = instance.validateIban();
        assertEquals(expResult, result);
        if(result != expResult)
            fail("Het juiste resultaat komt niet terug - validateIbanFail");
    }
    
}
