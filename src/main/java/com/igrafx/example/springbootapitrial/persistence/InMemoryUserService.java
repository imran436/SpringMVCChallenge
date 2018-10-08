/*
 * Copyright 2018 iGrafx, LLC,
 * All Rights Reserved.
 * This material is confidential and a trade secret.
 *
 * http://www.igrafx.com
 */
package com.igrafx.example.springbootapitrial.persistence;

import com.igrafx.example.springbootapitrial.objects.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nils Peuser <nils.peuser@igrafx.com>
 */
public class InMemoryUserService implements UserService
{
   private final Map<Integer, User> users = new HashMap<>();
   
   private int counter = 0;

   @Override
   public List<User> list()
   {
      return(Collections.unmodifiableList(new ArrayList<>(users.values())));
   }

   @Override
   public User get(int id)
   {
      return users.get(id);
   }

   @Override
   public User save(User user)
   {
      if(user.getId() > 0)
      {
         users.computeIfPresent(user.getId(), (k, o) -> user);
         return user;
      }
      else
      {
         int newUserId = ++counter;
         User newUser = new User(newUserId, user);
         users.put(newUser.getId(), newUser);
         return newUser;
      }
   }
   
}
