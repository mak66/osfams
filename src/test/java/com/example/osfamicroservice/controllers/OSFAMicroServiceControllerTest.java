/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.osfamicroservice.controllers;

import com.example.osfamicroservice.OSFAMicroService;
import com.example.osfamicroservice.controllers.OSFAMicroServiceController;
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
        OSFAMicroService.setOSFAMS_SERVICE("upper");
        OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

    @Test
    public void testToUppercaseNotNull() {
        String intext = "banana";
        OSFAMicroService.setOSFAMS_SERVICE("upper");
        OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "BANANA";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

    @Test
    public void testToUppercaseNull() {
        String intext = null;
        OSFAMicroService.setOSFAMS_SERVICE("upper");
        OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "upper of nothing IS NOTHING!!!!!";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

    @Test
    public void testToUppercaseMixedCase() {
        String intext = "ApPlE";
        OSFAMicroService.setOSFAMS_SERVICE("upper");
        OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "APPLE";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

    @Test
    public void testToUppercaseUCAlready() {
        String intext = "NOCHANGES";
        OSFAMicroService.setOSFAMS_SERVICE("upper");
        OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "NOCHANGES";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

    @Test
    public void testToUppercasePunctuation() {
        String intext = "bert&ernie";
        OSFAMicroService.setOSFAMS_SERVICE("upper");
        OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "BERT&ERNIE";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

    @Test
    public void testToUppercaseNumbers() {
        String intext = "123a**#x";
        OSFAMicroService.setOSFAMS_SERVICE("upper");
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
        OSFAMicroService.setOSFAMS_SERVICE("lower");
        OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

    @Test
    public void testToLowercaseNotNull() {
        String intext = "BANANA";
         OSFAMicroService.setOSFAMS_SERVICE("lower");
       OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "banana";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

    @Test
    public void testToLowercaseNull() {
        String intext = null;
         OSFAMicroService.setOSFAMS_SERVICE("lower");
       OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "lower of nothing IS NOTHING!!!!!";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

    @Test
    public void testToLowercaseMixedCase() {
        String intext = "aPPlE";
         OSFAMicroService.setOSFAMS_SERVICE("lower");
       OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "apple";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

    @Test
    public void testToLowercaseUCAlready() {
        String intext = "nochanges";
         OSFAMicroService.setOSFAMS_SERVICE("lower");
       OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "nochanges";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

    @Test
    public void testToLowercasePunctuation() {
        String intext = "BERT&ERNIE";
         OSFAMicroService.setOSFAMS_SERVICE("lower");
       OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "bert&ernie";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

    @Test
    public void testToLowercaseNumbers() {
        String intext = "123A**#X";
         OSFAMicroService.setOSFAMS_SERVICE("lower");
       OSFAMicroServiceController instance = new OSFAMicroServiceController();
        String expResult = "123a**#x";
        String result = instance.doTransformation(intext);
        assertEquals(expResult, result);
    }

}
