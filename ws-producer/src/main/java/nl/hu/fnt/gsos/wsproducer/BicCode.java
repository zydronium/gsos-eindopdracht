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
public class BicCode {
    private String bicCode;
    public BicCode(String bc) {
        bicCode = bc;
    }
    public String getBankCode() {
        String returnCode;
        switch (bicCode) {
            case "ABNANL2A":  returnCode = "ABNA";
                     break;
            case "AEGONL2U":  returnCode = "AEGO";
                     break;
            case "ANAANL21":  returnCode = "ANAA";
                     break;
            case "ANDLNL2A":  returnCode = "ANDL";
                     break;
            case "ARBNNL22":  returnCode = "ARBN";
                     break;
            case "ARSNNL21":  returnCode = "ARSN";
                     break;
            case "ARTENL2A":  returnCode = "ARTE";
                     break;
            case "ASNBNL21":  returnCode = "ASNB";
                     break;
            case "ATBANL2A":  returnCode = "ATBA";
                     break;
            case "BBRUNL2X":  returnCode = "BBRU";
                     break;
            case "BCDMNL22":  returnCode = "BCDM";
                     break;
            case "BCITNL2A":  returnCode = "BCIT";
                     break;
            case "BICKNL2A":  returnCode = "BICK";
                     break;
            case "BINKNL21":  returnCode = "BINK";
                     break;
            case "BKCHNL2R":  returnCode = "BKCH";
                     break;
            case "BKMGNL2A":  returnCode = "BKMG";
                     break;
            case "BLGWNL21":  returnCode = "BLGW";
                     break;
            case "BMEUNL21":  returnCode = "BMEU";
                     break;
            case "BNGHNL2G":  returnCode = "BNGH";
                     break;
            case "BNPANL2A":  returnCode = "BNPA";
                     break;
            case "BOFANLNX":  returnCode = "BOFA";
                     break;
            case "BOFSNL21002":  returnCode = "BOFS";
                     break;
            case "BOTKNL2X":  returnCode = "BOTK";
                     break;
            case "BUNQNL2A":  returnCode = "BUNQ";
                     break;
            case "CHASNL2X":  returnCode = "CHAS";
                     break;
            case "CITCNL2A":  returnCode = "CITC";
                     break;
            case "CITINL2X":  returnCode = "CITI";
                     break;
            case "COBANL2X":  returnCode = "COBA";
                     break;
            case "DEUTNL2N":  returnCode = "DEUT";
                     break;
            case "DHBNNL2R":  returnCode = "DHBN";
                     break;
            case "DLBKNL2A":  returnCode = "DLBK";
                     break;
            case "DNIBNL2G":  returnCode = "DNIB";
                     break;
            case "FBHLNL2A":  returnCode = "FBHL";
                     break;
            case "FLORNL2A":  returnCode = "FLOR";
                     break;
            case "FRBKNL2L":  returnCode = "FRBK";
                     break;
            case "FRGHNL21":  returnCode = "FRGH";
                     break;
            case "FVLBNL22":  returnCode = "FVLB";
                     break;
            case "GILLNL2A":  returnCode = "GILL";
                     break;
            case "HANDNL2A":  returnCode = "HAND";
                     break;
            case "HHBANL22":  returnCode = "HHBA";
                     break;
            case "HSBCNL2A":  returnCode = "HSBC";
                     break;
            case "ICBKNL2A":  returnCode = "ICBK";
                     break;
            case "INGBNL2A":  returnCode = "INGB";
                     break;
            case "INSINL2A":  returnCode = "INSI";
                     break;
            case "ISBKNL2A":  returnCode = "ISBK";
                     break;
            case "KABANL2A":  returnCode = "KABA";
                     break;
            case "KASANL2A":  returnCode = "KASA";
                     break;
            case "KNABNL2H":  returnCode = "KNAB";
                     break;
            case "KOEXNL2A":  returnCode = "KOEX";
                     break;
            case "KREDNL2X":  returnCode = "KRED";
                     break;
            case "LOCYNL2A":  returnCode = "LOCY";
                     break;
            case "LOYDNL2A":  returnCode = "LOYD";
                     break;
            case "LPLNNL2F":  returnCode = "LPLN";
                     break;
            case "MHCBNL2A":  returnCode = "MHCB";
                     break;
            case "NNBANL2G":  returnCode = "NNBA";
                     break;
            case "NWABNL2G":  returnCode = "NWAB";
                     break;
            case "OVBNNL22":  returnCode = "OVBN";
                     break;
            case "RABONL2U":  returnCode = "RABO";
                     break;
            case "RBOSNL2A":  returnCode = "RBOS";
                     break;
            case "RBRBNL21":  returnCode = "RBRB";
                     break;
            case "SNSBNL2A":  returnCode = "SNSB";
                     break;
            case "SOGENL2A":  returnCode = "SOGE";
                     break;
            case "STALNL2G":  returnCode = "STAL";
                     break;
            case "TEBUNL2A":  returnCode = "TEBU";
                     break;
            case "TRIONL2U":  returnCode = "TRIO";
                     break;
            case "UBSWNL2A":  returnCode = "UBSW";
                     break;
            case "UGBINL2A":  returnCode = "UGBI";
                     break;
            case "VOWANL21":  returnCode = "VOWA";
                     break;
            case "ZWLBNL21":  returnCode = "ZWLB";
                     break;
            default: returnCode = "false";
                     break;
        }
        
        return returnCode;
    }
}
