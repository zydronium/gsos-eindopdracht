/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hu.fnt.gsos.wsproducer;

import java.math.BigInteger;

/**
 *
 * @author Jelle
 */
public class IbanAccount {
    public String countryCode;
    public String bankCode;
    public String bankAccount;
    public String checkCode;
    public IbanAccount(String bc, String ba, String cc, String co) {
        countryCode = co;
        checkCode = cc;
        bankCode = bc;
        bankAccount = ba;
    }
    
    public String generateInteger() {
        String ibanTest = bankCode + bankAccount + countryCode + checkCode;
        StringBuilder numericAccountNumber = new StringBuilder();
        for (int i = 0; i < ibanTest.length(); i++) {
            numericAccountNumber.append(Character.getNumericValue(ibanTest.charAt(i)));
        }
        return numericAccountNumber.toString();
    }
    
    public String generateIban() {
        BigInteger ibanNumber = new BigInteger(generateInteger());
        int result = ibanNumber.mod(BigInteger.valueOf(97)).intValue();
        int cc = 98 - result;
        checkCode = cc +"";
        return countryCode + checkCode + bankCode + bankAccount;
    }
    
    public boolean validateIban() {
        BigInteger ibanNumber = new BigInteger(generateInteger());
        int result = ibanNumber.mod(BigInteger.valueOf(97)).intValue();
        if(result == 1) {
            return true;
        }else{
            return false;
        }
    }
}
