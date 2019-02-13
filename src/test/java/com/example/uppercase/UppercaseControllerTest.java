/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.uppercase;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ngan
 */
public class UppercaseControllerTest {
    
    public UppercaseControllerTest() {
    }

    /**
     * Test toUppercase method, of class UppercaseController.
     */
    @Test
    public void testToUppercaseEmpty() {
        String intext = "";
        UppercaseController instance = new UppercaseController();
        String expResult = "";
        String result = instance.toUppercase(intext);
        assertEquals(expResult, result);
    }
    @Test
     public void testToUppercaseNotNull() {
        String intext = "banana";
        UppercaseController instance = new UppercaseController();
        String expResult = "BANANA";
        String result = instance.toUppercase(intext);
        assertEquals(expResult, result);
    }
    @Test
     public void testToUppercaseNull() {
        String intext = null;
        UppercaseController instance = new UppercaseController();
        String expResult = "upper case of nothing IS NOTHING!!!!!";
        String result = instance.toUppercase(intext);
        assertEquals(expResult, result);
    }
     @Test
     public void testToUppercaseMixedCase() {
        String intext = "ApPlE";
        UppercaseController instance = new UppercaseController();
        String expResult = "APPLE";
        String result = instance.toUppercase(intext);
        assertEquals(expResult, result);
    }
      @Test
     public void testToUppercaseUCAlready() {
        String intext = "NOCHANGES";
        UppercaseController instance = new UppercaseController();
        String expResult = "NOCHANGES";
        String result = instance.toUppercase(intext);
        assertEquals(expResult, result);
    }
      @Test
     public void testToUppercasePunctuation() {
        String intext = "bert&ernie";
        UppercaseController instance = new UppercaseController();
        String expResult = "BERT&ERNIE";
        String result = instance.toUppercase(intext);
        assertEquals(expResult, result);
    }
      @Test
     public void testToUppercaseNumbers() {
        String intext = "123a**#x";
        UppercaseController instance = new UppercaseController();
        String expResult = "123A**#X";
        String result = instance.toUppercase(intext);
        assertEquals(expResult, result);
    }

}
