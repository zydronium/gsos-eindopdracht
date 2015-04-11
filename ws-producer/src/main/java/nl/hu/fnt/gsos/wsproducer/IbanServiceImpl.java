package nl.hu.fnt.gsos.wsproducer;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import javax.jws.WebService;

import nl.hu.fnt.gsos.wsinterface.*;

@WebService(endpointInterface = "nl.hu.fnt.gsos.wsinterface.IbanServiceSoap")
public class IbanServiceImpl implements IbanServiceSoap {

    @Override
    public ConvertorResponse convertor(ConvertorRequest convertorrequest) throws Applicationfault {
        ObjectFactory factory = new ObjectFactory();
        ConvertorResponse response = factory.createConvertorResponse();
        try {
            int bankAccount = (int) convertorrequest.getAccountNumber();
            ClassicAccount ca = new ClassicAccount(bankAccount);
            if (!ca.isCorrectAccountNumber()) {
                ExceptionMessage x = factory.createExceptionMessage();
                x.setCode(BigInteger.valueOf(2));
                x.setMessage("Banknummer is geen geldige banknummer");
                Applicationfault fault = new Applicationfault(
                        "Banknummer is geen geldige banknummer", x);
                throw fault;
            }
            String bankAccountString = "0"+bankAccount;
            
            String bicCode = convertorrequest.getBicCode();
            BicCode bc = new BicCode(bicCode);
            String bankCode = bc.getBankCode();
            if (bankCode.equals("false")) {
                ExceptionMessage x = factory.createExceptionMessage();
                x.setCode(BigInteger.valueOf(2));
                x.setMessage("Kan bank niet vinden");
                Applicationfault fault = new Applicationfault(
                        "Kan bank niet vinden", x);
                throw fault;
            }

            IbanAccount ia = new IbanAccount(bankCode, bankAccountString, "00", "NL");
            response.setNewAccountNumber(ia.generateIban());
        } catch (RuntimeException e) {
            ExceptionMessage x = factory.createExceptionMessage();
            x.setCode(BigInteger.valueOf(1));
            x.setMessage("fout enzo");
            Applicationfault fault = new Applicationfault(
                    "Er is iets mis gegaan tijdens het converten van een klassieke banknummer naar iban", x);
            throw fault;
        }
        return response;
    }

    @Override
    public ValidatorResponse validator(ValidatorRequest validatorrequest) throws Applicationfault {
        ObjectFactory factory = new ObjectFactory();
        ValidatorResponse response = factory.createValidatorResponse();
        try {
            String bankAccount = validatorrequest.getAccountNumber();
            IbanAccount ia = new IbanAccount(bankAccount.substring(4, 8), bankAccount.substring(8), bankAccount.substring(2, 4), bankAccount.substring(0, 2));
            if (!ia.validateIban()) {
                response.setIsIban(false);
            }else{
                response.setIsIban(true);
            }
        } catch (RuntimeException e) {
            ExceptionMessage x = factory.createExceptionMessage();
            x.setCode(BigInteger.valueOf(1));
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            x.setMessage(errors.toString());
            Applicationfault fault = new Applicationfault(
                    "Er is iets mis gegaan tijdens het valideren van de ibannummer", x);
            throw fault;
        }
        return response;
    }

}
