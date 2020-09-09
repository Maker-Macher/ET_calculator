/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.calcultorBackEnd;
import java.math.BigDecimal;
import java.math.MathContext;

/**
 *
 * @author ForZa
 */
public class shortToLong {
    
    public static String convert(String num, String y){
                
        if(!"".equals(num)){
            
            num = num.replaceAll("([,])|([a-z,A-Z])", "");
            BigDecimal x = new BigDecimal(num);

            int exp;

            switch(y){
                case "P":
                    exp = 15;
                    break;
                case "T":
                    exp = 12;
                    break;
                case "G":
                    exp = 9;
                    break;
                case "M":
                    exp = 6;
                    break;
                case "k":
                    exp = 3;
                    break;
                case "m":
                    exp = -3;
                    break;
                case "µ":
                    exp = -6;
                    break;
                case "n":
                    exp = -9;
                    break;
                default:
                    exp = 0;
                    break;
            }

            BigDecimal number = x.multiply(BigDecimal.TEN.pow(exp,MathContext.DECIMAL128));
            
            return number.toString();
        }
        else{
            return "No Number";
        }
    }    
}
