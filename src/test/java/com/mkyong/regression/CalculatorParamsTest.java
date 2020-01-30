package com.mkyong.regression;

import com.lits.calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.text.Bidi;

public class CalculatorParamsTest {

    Calculator calculator = new Calculator();

    @Test (groups = {"calculator", "smoke", "full"},
            dataProvider = "dataForAdd")
    public void  AddTwoNumbers(BigDecimal a, BigDecimal b, BigDecimal result) {

        //When
        calculator.setValue(a);

        //Then
        Assert.assertEquals(calculator.getCurrentAmount(), a);

        //When
        calculator.add(b);

        //Then

        Assert.assertTrue(result.compareTo(calculator.getCurrentAmount()) == 0);
        System.out.println(calculator.getCurrentAmount());

    }

    @Test (dataProvider = "dataForSubtract",
            description = "Test for subtracting two values"
    )
    public void TestSubtract (BigDecimal a, BigDecimal b, BigDecimal result) {


        //When
        calculator.setValue(a);

        //Then
        Assert.assertEquals(calculator.getCurrentAmount(), a);


        //When
        calculator.subtract(b);

        //Then

        Assert.assertTrue(result.compareTo(calculator.getCurrentAmount()) == 0);
        System.out.println(calculator.getCurrentAmount());

    }




    @DataProvider
    public Object[][] dataForAdd() {

        return new Object[][] {
                {BigDecimal.valueOf(1), BigDecimal.valueOf(0.6), BigDecimal.valueOf(1.6)},
                {BigDecimal.valueOf(45), BigDecimal.valueOf(-1), BigDecimal.valueOf(44)},
                {BigDecimal.valueOf(-15), BigDecimal.valueOf(-6), BigDecimal.valueOf(-21)},
                {BigDecimal.valueOf(0.000002), BigDecimal.valueOf(0.00000007), BigDecimal.valueOf(0.000002070)}
        };
    }

    @DataProvider
    public Object[][] dataForSubtract() {

        return new Object[][] {
                {BigDecimal.valueOf(1), BigDecimal.valueOf(0.6), BigDecimal.valueOf(0.4)},
                {BigDecimal.valueOf(45), BigDecimal.valueOf(-1), BigDecimal.valueOf(46)},
                {BigDecimal.valueOf(-15), BigDecimal.valueOf(-6), BigDecimal.valueOf(-9)},
                {BigDecimal.valueOf(0.000002), BigDecimal.valueOf(0.00000007), BigDecimal.valueOf(0.00000193)}
        };
    }

}
