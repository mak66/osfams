/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.osfamicroservice.controllers;

import com.example.osfamicroservice.GlobalValues;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    static final Logger log = LoggerFactory.getLogger(OSFAMicroServiceController.class);

    @CrossOrigin
    @GetMapping("/{intext}")
    public String doTransformation(@PathVariable String intext) {
        // log out the request and T2L for debug purposes
        log.info(GlobalValues.getSERVICE() + 
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
            switch (GlobalValues.getSERVICE()) {
                case "upper":
                    retVal = toUpper(intext);
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
               case "reversed":
                    retVal = toReversed(intext);
                    break;
               default:
                    retVal = "unsupported function";
                    break;
            }
            // call our chained service (might not be one but will return ok anyway)
            retVal = callOtherMS(retVal);
            //log our transaction to the db
            logTransactionToMongoDB(intext,retVal);
            //return the  updated (potentially) value
            return retVal;
        }

        return GlobalValues.getSERVICE() + " of nothing IS NOTHING!!!!!";
    }

    //simple method to return supplied string in uppercase
    private String toUpper(String intext) {
        return intext.toUpperCase();
    }
    
    //simple method to return supplied string in reverse
    private String toReversed(String intext) {
        return new StringBuilder(intext).reverse().toString();
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
            log.info("targetURL=["+targetURL+"]");
            
            String retVal;
            try{
                retVal = restTemplate.getForObject(targetURL, String.class);
            }catch(Exception ex){ // a bit naughty but for these purposes not crashing is good enough
                log.error(ex.getMessage());
                retVal = intext;
            }
            
        return retVal;
    }
    //log requests to our mongodb through our mongoms api
    // **for the purposes of this exercise not bothered if it fails
    private void logTransactionToMongoDB(String data,String result){
        
            RestTemplate restTemplate = new RestTemplate();
            String targetURL;
            targetURL = "http://mongoms:8080/logentry/"+
                    GlobalValues.getSERVICE()+"/"+
                    data + "/" +
                    GlobalValues.getTIME_TO_LIVE() + "/" +
                    result;
            
            String retVal;
            try{
                retVal = restTemplate.getForObject(targetURL, String.class);
            }catch(Exception ex){ // a bit naughty but for these purposes not crashing is good enough
                log.error(ex.getMessage());
            }
            
    }

}
