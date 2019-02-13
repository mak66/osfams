/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.osfamicroservice.controllers;

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
        System.out.println(OSFAMicroService.getOSFAMS_SERVICE() + ":Requested[" + intext + "]");
        if (intext != null) {
            switch (OSFAMicroService.getOSFAMS_SERVICE()) {
                case "upper":
                    return toUpperService(intext);

                case "lower":
                    return toLowerCase(intext);

                default:
                    return "unsupported function";

            }
        }

        return OSFAMicroService.getOSFAMS_SERVICE()+" of nothing IS NOTHING!!!!!";
    }

    private String toUpperService(String intext) {
        return intext.toUpperCase();
    }

    private String toLowerCase(String intext) {
        return intext.toLowerCase();
    }

}
