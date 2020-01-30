package com.mkyong.regression;

import com.lits.calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.MathContext;

public class DegRegTest {


    private Calculator calculator = new Calculator();

    @Test (dataProvider = "dataForRADandDEG", groups = {"smoke", "full"})
    public void ConvertRadToDeg(BigDecimal a, BigDecimal b){


        MathContext m = new MathContext(4);
        //When
        calculator.setValue(b);

        //Then
        Assert.assertEquals(calculator.getCurrentAmount(), b);

        //When
        calculator.convertToDEG();

        //Than
        Assert.assertEquals(calculator.getCurrentAmount().round(m), a.round(m));

    }




    @Test (dataProvider = "dataForRADandDEG", groups = {"smoke", "full"})
    public void ConvertDegToRad(BigDecimal a, BigDecimal b){

        MathContext m = new MathContext(12);

        //When
        calculator.setValue(a);

        //Then
        Assert.assertEquals(calculator.getCurrentAmount(), a);

        //When
        calculator.convertToRAD();

        Assert.assertEquals(calculator.getCurrentAmount().round(m), b.round(m));





        //Than
    //    Assert.assertEquals(calculator.getCurrentAmount(), BigDecimal.valueOf(1.396263401595440));
      //  System.out.println(calculator.getCurrentAmount());


    }


    @DataProvider
    public Object[][] dataForRADandDEG() {

        return new Object[][] {
                {BigDecimal.valueOf(180), BigDecimal.valueOf(Math.PI)},
                {BigDecimal.valueOf(150),  BigDecimal.valueOf(5*Math.PI/6)},
                { BigDecimal.valueOf(135),  BigDecimal.valueOf(3*Math.PI/4)},
                { BigDecimal.valueOf(120),  BigDecimal.valueOf(2*Math.PI/3)},
                { BigDecimal.valueOf(90),  BigDecimal.valueOf(Math.PI/2)},
                { BigDecimal.valueOf(60),  BigDecimal.valueOf(Math.PI/3)},
                { BigDecimal.valueOf(45),  BigDecimal.valueOf(Math.PI/4)},
                { BigDecimal.valueOf(30),  BigDecimal.valueOf(Math.PI/6)}
               // { BigDecimal.valueOf(0),  BigDecimal.valueOf(0)}
        };
    }

}
