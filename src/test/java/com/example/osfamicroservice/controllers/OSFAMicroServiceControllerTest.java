package com.example.osfamicroservice.controllers;

import com.example.osfamicroservice.GlobalValues;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ngan
 */
public class OSFAMicroServiceControllerTest {

    public OSFAMicroServiceControllerTest() {
    }

    /**
     * Test upper functionality of class OSFAMicroServiceController.
     */
    @Test
    public void testToUppercaseEmpty() {
        String intext = "";
        GlobalValues.initGlobals("upper", 5);
        OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

    @Test
    public void testToUppercaseNotNull() {
        String intext = "banana";
        GlobalValues.initGlobals("upper", 5);
        OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "BANANA";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

    @Test
    public void testToUppercaseNull() {
        String intext = null;
        GlobalValues.initGlobals("upper", 5);
        OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "upper of nothing IS NOTHING!!!!!";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

    @Test
    public void testToUppercaseMixedCase() {
        String intext = "ApPlE";
        GlobalValues.initGlobals("upper", 5);
        OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "APPLE";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

    @Test
    public void testToUppercaseUCAlready() {
        String intext = "NOCHANGES";
        GlobalValues.initGlobals("upper", 5);
        OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "NOCHANGES";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

    @Test
    public void testToUppercasePunctuation() {
        String intext = "bert&ernie";
        GlobalValues.initGlobals("upper", 5);
        OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "BERT&ERNIE";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

    @Test
    public void testToUppercaseNumbers() {
        String intext = "123a**#x";
        GlobalValues.initGlobals("upper", 5);
        OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "123A**#X";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

    /**
     * Test lower functionality of class OSFAMicroServiceController.
     */
    @Test
    public void testToLowercaseEmpty() {
        String intext = "";
        GlobalValues.initGlobals("lower", 5);
        OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

    @Test
    public void testToLowercaseNotNull() {
        String intext = "BANANA";
        GlobalValues.initGlobals("lower", 5);
        OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "banana";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

    @Test
    public void testToLowercaseNull() {
        String intext = null;
        GlobalValues.initGlobals("lower", 5);
        OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "lower of nothing IS NOTHING!!!!!";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

    @Test
    public void testToLowercaseMixedCase() {
        String intext = "aPPlE";
        GlobalValues.initGlobals("lower", 5);
        OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "apple";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

    @Test
    public void testToLowercaseUCAlready() {
        String intext = "nochanges";
        GlobalValues.initGlobals("lower", 5);
        OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "nochanges";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

    @Test
    public void testToLowercasePunctuation() {
        String intext = "BERT&ERNIE";
        GlobalValues.initGlobals("lower", 5);
        OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "bert&ernie";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

    @Test
    public void testToLowercaseNumbers() {
        String intext = "123A**#X";
        GlobalValues.initGlobals("lower", 5);
        OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "123a**#x";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

    /**
     * Test braced functionality of class OSFAMicroServiceController.
     */
    @Test
    public void testTBracedEmpty() {
        String intext = "";
        GlobalValues.initGlobals("braced", 5);
        OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "{}";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

    @Test
    public void testBracedNotNull() {
        String intext = "banana";
        GlobalValues.initGlobals("braced", 5);
        OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "{banana}";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

    /**
     * Test unbraced functionality of class OSFAMicroServiceController.
     */
    @Test
    public void testTUnbracedEmpty() {
        String intext = "";
        GlobalValues.initGlobals("unbraced", 5);
        OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

    @Test
    public void testUnbracedNotNull() {
        String intext = "{banana}";
        GlobalValues.initGlobals("unbraced", 5);
        OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "banana";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

    @Test
    public void testUnbracedMultiple() {
        String intext = "{{a}}";
        GlobalValues.initGlobals("unbraced", 5);
        OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "{a}";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

    @Test
    public void testUnbracedStartOnly() {
        String intext = "{a";
        GlobalValues.initGlobals("unbraced", 5);
        OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "{a";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

    @Test
    public void testUnbracedEndOnly() {
        String intext = "a}";
        GlobalValues.initGlobals("unbraced", 5);
        OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "a}";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

}
