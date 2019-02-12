/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.uppercase;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ngan
 */
@RestController
public class UppercaseController {
    
    @GetMapping("/{intext}")
    public String touppercase(@PathVariable String intext){
        return intext.toUpperCase();
    }
    
    
}
