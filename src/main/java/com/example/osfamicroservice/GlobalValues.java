/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.osfamicroservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GlobalValues {
    static final Logger log = LoggerFactory.getLogger(GlobalValues.class);

    private static String SERVICE;
    private static int TIME_TO_LIVE;
    private static String CHAINED_MS;
    public final static String NO_URL= "--none--";

    public static String getCHAINED_MS() {
        return (CHAINED_MS == null )? NO_URL : CHAINED_MS;
    }

    public static void setCHAINED_MS(String CHAINED_MS) {
        GlobalValues.CHAINED_MS = CHAINED_MS;
    }

    public static int getTIME_TO_LIVE() {
        return TIME_TO_LIVE;
    }
    public static int decrementTIME_TO_LIVE() {
        return --TIME_TO_LIVE;
    }

    public static void setTIME_TO_LIVE(int TIME_TO_LIVE) {
        GlobalValues.TIME_TO_LIVE = TIME_TO_LIVE;
    }

    public static void setSERVICE(String SERVICE) {
        GlobalValues.SERVICE = SERVICE;
    }

    public static String getSERVICE() {
        return SERVICE;
    }
    
    public static void initGlobals(String service, int time_to_live){
        setSERVICE(service);
        setTIME_TO_LIVE(time_to_live);
    }

    @Autowired
    public void autoSetOsfamService(@Value("${OSFAMS.SERVICE:upper}") String inval){
        setSERVICE(inval);
        log.info("***>MicroService running as ["+GlobalValues.getSERVICE()+"]");
    }
    @Autowired
    public void autoSetOTimeToLive(@Value("${OSFAMS.TIME.TO.LIVE:5}") String inval){
        setTIME_TO_LIVE(Integer.parseInt(inval));
        log.info("***>MicroService running with T2L ["+GlobalValues.getTIME_TO_LIVE()+"]");
    }
    @Autowired
    public void autoSetCHAINEDMS(@Value("${OSFAMS.CHAINED.MS:"+NO_URL+"}") String inval){
        if (inval == null) return;
        setCHAINED_MS(inval);
        log.info("***>MicroService running chained to ["+GlobalValues.getCHAINED_MS()+"]");
    }

}
