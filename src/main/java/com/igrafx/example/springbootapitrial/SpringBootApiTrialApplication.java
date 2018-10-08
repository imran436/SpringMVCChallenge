/*
 * Copyright 2018 iGrafx, LLC,
 * All Rights Reserved.
 * This material is confidential and a trade secret.
 *
 * http://www.igrafx.com
 */
package com.igrafx.example.springbootapitrial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author Nils Peuser <nils.peuser@igrafx.com>
 */
@SpringBootApplication(scanBasePackages = "com.igrafx.example")
public class SpringBootApiTrialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApiTrialApplication.class, args);
	}
}
