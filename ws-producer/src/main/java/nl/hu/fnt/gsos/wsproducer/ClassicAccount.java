/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hu.fnt.gsos.wsproducer;

/**
 *
 * @author Jelle
 */
public class ClassicAccount {

    private int accountNumber;

    public ClassicAccount(int an) {
        accountNumber = an;
    }

    public boolean isCorrectAccountNumber() {
        String temp = Integer.toString(accountNumber);
        if (temp.length() != 9) {
            return false;
        }
        int[] anArray = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            anArray[i] = temp.charAt(i) - '0';
        }
        int checkMultiplier = 9;
        int sum = 0;
        for (int checkNumber : anArray) {
            sum = sum + (checkMultiplier * checkNumber);
            checkMultiplier--;
        }
        double divide = sum / 11.0;
        if ((divide == Math.floor(divide)) && !Double.isInfinite(divide)) {
            return true;
        }
        return false;
    }
}
