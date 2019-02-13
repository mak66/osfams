package com.example.osfamicroservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OSFAMicroService {
    @Value("${OSFAMS_SERVICE}")
    static String OSFAMS_SERVICE;

    public static void setOSFAMS_SERVICE(String OSFAMS_SERVICE) {
        OSFAMicroService.OSFAMS_SERVICE = OSFAMS_SERVICE;
    }

    public static String getOSFAMS_SERVICE() {
        return OSFAMS_SERVICE;
    }

	public static void main(String[] args) {
		SpringApplication.run(OSFAMicroService.class, args);
	}

}

