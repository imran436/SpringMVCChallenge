/*
 * Copyright 2018 iGrafx, LLC,
 * All Rights Reserved.
 * This material is confidential and a trade secret.
 *
 * http://www.igrafx.com
 */
package com.igrafx.example.springbootapitrial.spring;

import com.igrafx.example.springbootapitrial.persistence.InMemoryUserService;
import com.igrafx.example.springbootapitrial.persistence.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Nils Peuser <nils.peuser@igrafx.com>
 */
@Configuration
public class PersistenceConfig
{
   @Bean
   public UserService userService()
   {
      return new InMemoryUserService();
   }
}
