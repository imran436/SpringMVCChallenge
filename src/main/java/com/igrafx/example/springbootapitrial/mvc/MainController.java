/*
 * Copyright 2018 iGrafx, LLC,
 * All Rights Reserved.
 * This material is confidential and a trade secret.
 *
 * http://www.igrafx.com
 */
package com.igrafx.example.springbootapitrial.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Nils Peuser <nils.peuser@igrafx.com>
 */
@Controller
public class MainController
{
   @RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
   public String main()
   {
      return("main");
   }
}
