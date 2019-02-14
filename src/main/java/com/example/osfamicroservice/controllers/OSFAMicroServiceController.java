/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.osfamicroservice.controllers;

import com.example.osfamicroservice.GlobalValues;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author ngan
 */
@RestController
public class OSFAMicroServiceController {

    @CrossOrigin
    @GetMapping("/{intext}")
    public String doTransformation(@PathVariable String intext) {
        // log out the request and T2L for debug purposes
        System.out.println(GlobalValues.getOSFAMS_SERVICE() + 
                ":Requested[" + intext + "], T2L=[" + 
                GlobalValues.getTIME_TO_LIVE()+"]");
        
        //kill the server if it has reached the end of the T2L road...
        if (GlobalValues.decrementTIME_TO_LIVE() <= 0) {
            System.exit(2);
        }

        // assuming we have some text then return the apply appropriate transition and return the new value
        // based on the function we are running as
        if (intext != null) {
            String retVal;
            switch (GlobalValues.getOSFAMS_SERVICE()) {
                case "upper":
                    retVal = toUpperService(intext);
                    break;
                case "lower":
                    retVal = toLowerCase(intext);
                    break;
                case "braced":
                    retVal = toBraced(intext);
                    break;
               case "unbraced":
                    retVal = toUnbraced(intext);
                    break;
               default:
                    retVal = "unsupported function";
                    break;
            }
            return callOtherMS(retVal);
        }

        return GlobalValues.getOSFAMS_SERVICE() + " of nothing IS NOTHING!!!!!";
    }

    //simple emthod to return supplied string in uppercase
    private String toUpperService(String intext) {
        return intext.toUpperCase();
    }

    //return supplied sting in lowercase
    private String toLowerCase(String intext) {
        return intext.toLowerCase();
    }

    //return string enclosed in sq braces
    private String toBraced(String intext) {
        return "[" + intext + "]";
    }

    //return string with the first matched set of outer sq braces removed
    private String toUnbraced(String intext) {
        //look for a curly at the startand end of the string and remove 1 set
        if (intext.startsWith("[") && intext.endsWith("]")) {
            intext = intext.substring(1,intext.length() - 1);
        
        }
        return intext;
    }

    //make call out to other microservice
    private String callOtherMS(String intext){
        //if we don't have a chained MS then can't call it
        if (GlobalValues.getCHAINED_MS().equalsIgnoreCase(GlobalValues.NO_URL)) return intext;
        
            RestTemplate restTemplate = new RestTemplate();
            String targetURL;
            targetURL = "http://"+GlobalValues.getCHAINED_MS()+"/"+intext;
            System.out.println("targetURL=["+targetURL+"]");
            String retVal = restTemplate.getForObject(targetURL, String.class);
            
        return retVal;
    }


}
