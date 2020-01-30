package com.mkyong.regression;

import com.lits.calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.text.Bidi;

public class CalculatorAddOperaionTest {

    private Calculator calculator = new Calculator();

    @Test(expectedExceptions = {AssertionError.class})
    public void testExpectedException() {
        calculator.reset();
        calculator.setValue(BigDecimal.valueOf(20.0));
        Assert.assertEquals(calculator.getCurrentAmount(), BigDecimal.ZERO);

    }

    @Test (groups = {"calculator", "simple-operations", "add"},
            description = "Test for adding two values")
    public void TestAdd () {
        //Given
        BigDecimal a = BigDecimal.valueOf(0.1);
        BigDecimal b = BigDecimal.valueOf(0.2);

        //When
        calculator.setValue(a);

        //Then
        Assert.assertEquals(calculator.getCurrentAmount(), a);

        //When
        calculator.add(b);

        //Than
        Assert.assertEquals(calculator.getCurrentAmount(), BigDecimal.valueOf(0.3));
        System.out.println(calculator.getCurrentAmount());
    }


    @Test (description = "Test for subtracting two values")
    public void TestSubtract () {
        //Given
        BigDecimal a = BigDecimal.valueOf(100);
        BigDecimal b = BigDecimal.valueOf(200);

        //When
        calculator.setValue(a);

        //Then
        Assert.assertEquals(calculator.getCurrentAmount(), a);

        //When
        calculator.subtract(b);

        //Than
        Assert.assertEquals(calculator.getCurrentAmount(), BigDecimal.valueOf(-100));
        System.out.println(calculator.getCurrentAmount());
    }


    @Test (description = "Test for dividing two values")
    public void TestDivide() {
        //Given
        BigDecimal a = BigDecimal.valueOf(100);
        BigDecimal b = BigDecimal.valueOf(0.2);

        //When
        calculator.setValue(a);

        //Then
        Assert.assertEquals(calculator.getCurrentAmount(), a);

        //When
        calculator.divide(b);

        //Than
        Assert.assertEquals(calculator.getCurrentAmount(), BigDecimal.valueOf(500));
        System.out.println(calculator.getCurrentAmount());
    }

    @Test (description = "Test for multiplying two values")
    public void TestMultiply() {
        //Given
        BigDecimal a = BigDecimal.valueOf(100);
        BigDecimal b = BigDecimal.valueOf(1);

        //When
        calculator.setValue(a);

        //Then
        Assert.assertEquals(calculator.getCurrentAmount(), a);

        //When
        calculator.multiply(b);

        //ER
        //int er = 20;

        //Than
        Assert.assertEquals(calculator.getCurrentAmount(), BigDecimal.valueOf(100));
        System.out.println(calculator.getCurrentAmount());
    }

}
