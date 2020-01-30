package com.mkyong.hashing;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

 /** Unit test for simple App.**/
public class AppTest
{
        @BeforeClass
      public void beforeClass()
        {
            System.out.println("**** Test class AppTest Started");
        }

        @BeforeMethod

      public void beforeMethod()
        {
            System.out.println("**** Test METHODS from AppTest Started");
        }


        @Test (description = "Verify that test return true")
        public void testApp ()
        {
            assertTrue(true);
        }


    @Test
    public void testApp1 ()
    {
        assertTrue(true);
        assertEquals(10,10,"FAILEEEEEED");
    }

}
