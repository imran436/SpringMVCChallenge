/*
 * Copyright 2018 iGrafx, LLC,
 * All Rights Reserved.
 * This material is confidential and a trade secret.
 *
 * http://www.igrafx.com
 */
package com.igrafx.example.springbootapitrial.mvc;

import com.igrafx.example.springbootapitrial.objects.User;
import com.igrafx.example.springbootapitrial.persistence.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nils Peuser <nils.peuser@igrafx.com>
 */
@RestController
public class UserController
{
   private final UserService userService;

   @Autowired
   public UserController(UserService userService)
   {
      this.userService = userService;
   }

   @GetMapping("/users")
   public List<User> list()
   {
      return userService.list();
   }

   @GetMapping("/users/{id}")
   public User get(@PathVariable int id)
   {
      return userService.get(id);
   }
   
   @PutMapping("/users/{id}")
   public List<User> update(@PathVariable int id, @Valid @RequestBody User user) throws Exception
   {
      if(user.getId() == id){
      return userService.save(user);
      }
      else{
         throw new Exception("attempted to edit different id than exepected");
         //user = new User(id, user.getUserName(), user.getFirstName(), user.getLastName(), user.getEmail());
        // return userService.save(user);
      }
   }

   @PostMapping("/users")
   public List<User> create(@Valid @RequestBody User user) throws Exception
   {
      return userService.save(user);
      
   }

   @DeleteMapping("/users/{id}")
   public List<User> delete(@PathVariable int id) throws Exception{
      return userService.delete(id);
      
   }
   
}
