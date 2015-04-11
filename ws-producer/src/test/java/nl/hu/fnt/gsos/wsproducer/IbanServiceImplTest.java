/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hu.fnt.gsos.wsproducer;

import junit.framework.TestCase;
import nl.hu.fnt.gsos.wsinterface.ConvertorRequest;
import nl.hu.fnt.gsos.wsinterface.ConvertorResponse;
import nl.hu.fnt.gsos.wsinterface.ValidatorRequest;
import nl.hu.fnt.gsos.wsinterface.ValidatorResponse;

/**
 *
 * @author Jelle
 */
public class IbanServiceImplTest extends TestCase {
    
    public IbanServiceImplTest(String testName) {
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
     * Test of convertor method, of class IbanServiceImpl.
     */
    public void testConvertor() throws Exception {
        System.out.println("convertor");
        System.out.println("Genereer ibannummer - rekening: 123456789 - bank: VOWANL21 (Volkswagen Bank) - output: NL55VOWA0123456789");
        ConvertorRequest convertorrequest = null;
        convertorrequest = new ConvertorRequest(); 
        convertorrequest.setAccountNumber(123456789); 
        convertorrequest.setBicCode("VOWANL21");
        IbanServiceImpl instance = new IbanServiceImpl();
        ConvertorResponse expResult = null;
        expResult = new ConvertorResponse();
        expResult.setNewAccountNumber("NL55VOWA0123456789");
        ConvertorResponse result = instance.convertor(convertorrequest);
        assertEquals(expResult.getNewAccountNumber(), result.getNewAccountNumber());
        if(!result.getNewAccountNumber().equals(expResult.getNewAccountNumber()))
            fail("Het juiste resultaat komt niet terug - convertor");
    }

    /**
     * Test of Bank fail convertor method, of class IbanServiceImpl.
     */
    public void testConvertorBankFail() throws Exception {
        System.out.println("convertorBankFail");
        ConvertorRequest convertorrequest = null;
        convertorrequest = new ConvertorRequest(); 
        convertorrequest.setAccountNumber(123456789); 
        convertorrequest.setBicCode("VOWANL22");
        IbanServiceImpl instance = new IbanServiceImpl();
        String expResult = "Kan bank niet vinden";
        String returnResult = "";
        try {
            ConvertorResponse result = instance.convertor(convertorrequest);
        }catch(Exception e) {
            returnResult = e.getMessage();
        }
        assertEquals(expResult, returnResult);
        if(!returnResult.equals(expResult))
            fail("Het juiste resultaat komt niet terug - convertorBankFail");
    }

    /**
     * Test of Account fail convertor method, of class IbanServiceImpl.
     */
    public void testConvertorAccountFail() throws Exception {
        System.out.println("convertorAccountFail");
        ConvertorRequest convertorrequest = null;
        convertorrequest = new ConvertorRequest(); 
        convertorrequest.setAccountNumber(123456782); 
        convertorrequest.setBicCode("VOWANL21");
        IbanServiceImpl instance = new IbanServiceImpl();
        String expResult = "Banknummer is geen geldige banknummer";
        String returnResult = "";
        try {
            ConvertorResponse result = instance.convertor(convertorrequest);
        }catch(Exception e) {
            returnResult = e.getMessage();
        }
        assertEquals(expResult, returnResult);
        if(!returnResult.equals(expResult))
            fail("Het juiste resultaat komt niet terug - convertorAccountFail");
    }

    /**
     * Test of validator method, of class IbanServiceImpl.
     */
    public void testValidator() throws Exception {
        System.out.println("validator");
        ValidatorRequest validatorrequest = null;
        validatorrequest = new ValidatorRequest(); 
        validatorrequest.setAccountNumber("NL55VOWA0123456789");
        IbanServiceImpl instance = new IbanServiceImpl();
        ValidatorResponse expResult = null;
        expResult = new ValidatorResponse();
        expResult.setIsIban(true);
        ValidatorResponse result = instance.validator(validatorrequest);
        assertEquals(expResult.isIsIban(), result.isIsIban());
        if(result.isIsIban() != expResult.isIsIban())
            fail("Het juiste resultaat komt niet terug - validator");
    }

    /**
     * Test of Fail validator method, of class IbanServiceImpl.
     */
    public void testValidatorFail() throws Exception {
        System.out.println("validatorFail");
        ValidatorRequest validatorrequest = null;
        validatorrequest = new ValidatorRequest(); 
        validatorrequest.setAccountNumber("NL55VOWA0123456782");
        IbanServiceImpl instance = new IbanServiceImpl();
        ValidatorResponse expResult = null;
        expResult = new ValidatorResponse();
        expResult.setIsIban(false);
        ValidatorResponse result = instance.validator(validatorrequest);
        assertEquals(expResult.isIsIban(), result.isIsIban());
        if(result.isIsIban() != expResult.isIsIban())
            fail("Het juiste resultaat komt niet terug - validatorFail");
    }
    
}
