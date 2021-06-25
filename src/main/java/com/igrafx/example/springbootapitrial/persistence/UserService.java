/*
 * Copyright 2018 iGrafx, LLC,
 * All Rights Reserved.
 * This material is confidential and a trade secret.
 *
 * http://www.igrafx.com
 */
package com.igrafx.example.springbootapitrial.persistence;

import com.igrafx.example.springbootapitrial.objects.User;
import java.util.List;

/**
 *
 * @author Nils Peuser <nils.peuser@igrafx.com>
 */
public interface UserService 
{
   List<User> list();
   
   User get(int id);
   
   User save(User user) throws Exception;
   
   void delete(int id);
   
}
