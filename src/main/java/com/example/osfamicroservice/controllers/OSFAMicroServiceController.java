/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.osfamicroservice.controllers;

import com.example.osfamicroservice.GlobalValues;
import com.example.osfamicroservice.OSFAMicroService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ngan
 */
@RestController
public class OSFAMicroServiceController {

    @CrossOrigin
    @GetMapping("/{intext}")
    public String doTransformation(@PathVariable String intext) {
        // log out the request for debug purposes
        System.out.println(GlobalValues.getOSFAMS_SERVICE() + ":Requested[" + intext + "]");
        //kill the server if it has reached the end of the T2L road...
        if (GlobalValues.decrementTIME_TO_LIVE() <= 0)System.exit(2);
        
        // assuming we have some text then return the apply appropriate transition and return the new value
        // based on the function we are running as
        if (intext != null) {
            switch (GlobalValues.getOSFAMS_SERVICE()) {
                case "upper":
                    return toUpperService(intext);

                case "lower":
                    return toLowerCase(intext);
                    
                case "braced":
                    return "{"+intext+"}";
 
                case "unbraced":
                    if (intext.startsWith("{"))intext=intext.substring(1);
                    if (intext.endsWith("}")) intext=intext.substring(0,intext.length()-1);
                    return intext;

                default:
                    return "unsupported function";

            }
        }

        return GlobalValues.getOSFAMS_SERVICE()+" of nothing IS NOTHING!!!!!";
    }

    private String toUpperService(String intext) {
        return intext.toUpperCase();
    }

    private String toLowerCase(String intext) {
        return intext.toLowerCase();
    }

}
