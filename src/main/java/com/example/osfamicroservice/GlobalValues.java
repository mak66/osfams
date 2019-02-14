/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.osfamicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GlobalValues {

    private static String OSFAMS_SERVICE;
    private static int TIME_TO_LIVE;

    public static int getTIME_TO_LIVE() {
        return TIME_TO_LIVE;
    }
    public static int decrementTIME_TO_LIVE() {
        return --TIME_TO_LIVE;
    }

    public static void setTIME_TO_LIVE(int TIME_TO_LIVE) {
        GlobalValues.TIME_TO_LIVE = TIME_TO_LIVE;
    }

    public static void setOSFAMS_SERVICE(String OSFAMS_SERVICE) {
        GlobalValues.OSFAMS_SERVICE = OSFAMS_SERVICE;
    }

    public static String getOSFAMS_SERVICE() {
        return OSFAMS_SERVICE;
    }
    
    public static void initGlobals(String osfams_service, int time_to_live){
        setOSFAMS_SERVICE(osfams_service);
        setTIME_TO_LIVE(time_to_live);
    }

    @Autowired
    public void autoSetOsfamService(@Value("${OSFAMS.SERVICE:upper}") String inval){
        setOSFAMS_SERVICE(inval);
        System.out.println("***>MicroService running as ["+GlobalValues.getOSFAMS_SERVICE()+"]");
    }
    @Autowired
    public void autoSetOTimeToLive(@Value("${OSFAMS.TIME.TO.LIVE:5}") String inval){
        setTIME_TO_LIVE(Integer.parseInt(inval));
        System.out.println("***>MicroService running with T2L ["+GlobalValues.getTIME_TO_LIVE()+"]");
    }

}
