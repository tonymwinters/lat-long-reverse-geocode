package com.tw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LatLongApplication {

	public static void main(String[] args) {
		if(args.length > 0){
			System.setProperty("GOOGLE_API_KEY", args[0]);
		}
		SpringApplication.run(LatLongApplication.class, args);
	}
}
