/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.uppercase;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ngan
 */
@RestController
public class UppercaseController {
    
    @CrossOrigin
    @GetMapping("/{intext}")
    public String toUppercase(@PathVariable String intext){
        if (intext != null){
            return intext.toUpperCase();
        }
        
        return "upper case of nothing IS NOTHING!!!!!";
    }
    
    
}
