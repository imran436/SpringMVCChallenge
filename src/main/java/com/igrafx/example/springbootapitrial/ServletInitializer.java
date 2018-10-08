/*
 * Copyright 2018 iGrafx, LLC,
 * All Rights Reserved.
 * This material is confidential and a trade secret.
 *
 * http://www.igrafx.com
 */
package com.igrafx.example.springbootapitrial;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 
 * @author Nils Peuser <nils.peuser@igrafx.com>
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootApiTrialApplication.class);
	}

}
