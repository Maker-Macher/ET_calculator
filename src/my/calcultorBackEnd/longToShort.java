/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.calcultorBackEnd;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 *
 * @author ForZa
 */
public class longToShort {
    
    public static String convert(String x){
        
        x = x.replaceAll("([,])|([a-z,A-Z])", "");
        
        if(!"".equals(x)){

            BigDecimal number = new BigDecimal(x);
            String string = "";

            if(number.compareTo(BigDecimal.valueOf(1000000000000000L)) >= 0){

                number = number.multiply(BigDecimal.TEN.pow(-15,MathContext.DECIMAL32)).setScale(2, RoundingMode.CEILING);
                string = number + "P";
            }
            else if(number.compareTo(BigDecimal.valueOf(1000000000000000L)) < 0 && number.compareTo(BigDecimal.valueOf(1000000000000L))>= 0){

                number = number.multiply(BigDecimal.TEN.pow(-12,MathContext.DECIMAL32)).setScale(2, RoundingMode.CEILING);
                string = number + "T";
            }
            else if(number.compareTo(BigDecimal.valueOf(1000000000000L)) < 0 && number.compareTo(BigDecimal.valueOf(1000000000L))>= 0){

                number = number.multiply(BigDecimal.TEN.pow(-9,MathContext.DECIMAL32)).setScale(2, RoundingMode.CEILING);
                string = number + "G";
            }
            else if(number.compareTo(BigDecimal.valueOf(1000000000L)) < 0 && number.compareTo(BigDecimal.valueOf(1000000L))>= 0){

                number = number.multiply(BigDecimal.TEN.pow(-6,MathContext.DECIMAL32)).setScale(2, RoundingMode.CEILING);
                string = number + "M";
            }
            else if(number.compareTo(BigDecimal.valueOf(1000000L)) < 0 && number.compareTo(BigDecimal.valueOf(1000L))>= 0){

                number = number.multiply(BigDecimal.TEN.pow(-3,MathContext.DECIMAL32)).setScale(2, RoundingMode.CEILING);
                string = number + "k";
            }
            else if(number.compareTo(BigDecimal.valueOf(1000)) < 0 && number.compareTo(BigDecimal.valueOf(0.1))> 0){

                number = number.multiply(BigDecimal.TEN.pow(0,MathContext.DECIMAL32)).setScale(2, RoundingMode.CEILING);
                string = number + "";
            }
            else if(number.compareTo(BigDecimal.valueOf(0.1)) <= 0 && number.compareTo(BigDecimal.valueOf(0.0001))> 0){

                number = number.multiply(BigDecimal.TEN.pow(3,MathContext.DECIMAL32)).setScale(2, RoundingMode.CEILING);
                string = number + "m";
            }
            else if(number.compareTo(BigDecimal.valueOf(0.0001)) <= 0 && number.compareTo(BigDecimal.valueOf(0.0000001))> 0){

                number = number.multiply(BigDecimal.TEN.pow(6,MathContext.DECIMAL32)).setScale(2, RoundingMode.CEILING);
                string = number + "µ";
            }
            else if(number.compareTo(BigDecimal.valueOf(0.0000001)) <= 0){

                number = number.multiply(BigDecimal.TEN.pow(9,MathContext.DECIMAL32)).setScale(2, RoundingMode.CEILING);
                string = number + "n";
            }

            return string;
        }
        else{
            return "No Number";
        }
    }
}
