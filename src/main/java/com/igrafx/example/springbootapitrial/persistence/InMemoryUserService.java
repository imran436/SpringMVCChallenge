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
import java.util.Iterator;
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
   public User save(User user) throws Exception
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
         boolean usernameInUse = users.values().stream().anyMatch(u -> u.getUserName().equals(user.getUserName()));
         // Iterator<Map.Entry<Integer,User>> 
         // iterator = users.entrySet().iterator();
         // boolean userExists = false;
         // while ( iterator.hasNext()){
         //    Map.Entry<Integer, User>
         //    entry = iterator.next();
         //    if(newUser.getUserName() == entry.getValue().getUserName()){
         //       userExists = true;
         //    }
         // }
         if(!usernameInUse){
         users.put(newUser.getId(), newUser);
         return newUser;
         }
         else{
            throw new Exception("Username already exists. Please try a different Username");
         }
      }
   }
   
   @Override
   public void delete(int id){
      users.remove(id);
   }
}
