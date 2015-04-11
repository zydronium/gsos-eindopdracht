/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hu.fnt.gsos.wsconsumer;

import java.math.BigInteger;
import nl.hu.fnt.gsos.wsinterface.*;

/**
 *
 * @author Jelle
 */
public class Main {
    public static void main(String[] args) {
        IbanService ibanService = new IbanService();
        // Dit is de SEI
        IbanServiceSoap wsInterface = ibanService.getIbanServiceSoap();
        ConvertorRequest request1;
        ValidatorRequest request2;
        
        System.out.println("Genereer ibannummer - rekening: 123456789 - bank: VOWANL21 (Volkswagen Bank) - output: NL55VOWA0123456789");
        request1 = new ConvertorRequest(); 
        request1.setAccountNumber(123456789); 
        request1.setBicCode("VOWANL21");
        try {
            ConvertorResponse response = wsInterface.convertor(request1);
            System.out.println("Ibannummer: " + response.getNewAccountNumber().toString());
        }catch(Exception e) {
            System.out.println(e.toString());
        }

        System.out.println("Genereer ibannummer - rekening: 123456789 - bank: VOWANL22 (niet bestaand) - output: error");
        request1 = new ConvertorRequest(); 
        request1.setAccountNumber(123456789); 
        request1.setBicCode("VOWANL22");
        try {
            ConvertorResponse response = wsInterface.convertor(request1);
            System.out.println("Ibannummer: " + response.getNewAccountNumber().toString());
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("Genereer ibannummer - rekening: 123456782 - bank: VOWANL21 (Volkswagen Bank) - output: error");
        request1 = new ConvertorRequest(); 
        request1.setAccountNumber(123456782); 
        request1.setBicCode("VOWANL21");
        try {
            ConvertorResponse response = wsInterface.convertor(request1);
            System.out.println("Ibannummer: " + response.getNewAccountNumber().toString());
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("Valideer ibannummer - rekening: NL55VOWA0123456789 - output: true");
        request2 = new ValidatorRequest(); 
        request2.setAccountNumber("NL55VOWA0123456789");
        try {
            ValidatorResponse response = wsInterface.validator(request2);
            System.out.println("Ibannummer: " + response.isIsIban());
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("Valideer ibannummer - rekening: NL55VOWA0123456782 - output: false");
        request2 = new ValidatorRequest(); 
        request2.setAccountNumber("NL55VOWA0123456782");
        try {
            ValidatorResponse response = wsInterface.validator(request2);
            System.out.println("Ibannummer: " + response.isIsIban());
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
