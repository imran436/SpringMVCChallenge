/*
 * Copyright 2018 iGrafx, LLC,
 * All Rights Reserved.
 * This material is confidential and a trade secret.
 *
 * http://www.igrafx.com
 */
package com.igrafx.example.springbootapitrial.objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Email;

/**
 *
 * @author Nils Peuser <nils.peuser@igrafx.com>
 */
public class User
{

   @NotNull
   private final String userName;

   private final int id;

   @NotNull
   private final String firstName;

   @NotNull
   private final String lastName;

   @Email
   private final String email;
   @JsonCreator
   public User(
           @JsonProperty("id") int id,
           @JsonProperty("userName") String userName,
           @JsonProperty("firstName") String firstName,
           @JsonProperty("lastName") String lastName,
           @JsonProperty("email") String email
   )
   {
      this.userName = userName;
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }
   
   public User(int id, User user)
   {
      this(id, user.userName, user.firstName, user.lastName, user.email);
   }

   public String getUserName()
   {
      return userName;
   }

   public int getId()
   {
      return id;
   }

   public String getFirstName()
   {
      return firstName;
   }

   public String getLastName()
   {
      return lastName;
   }
   public String getEmail()
   {
      return email;
   }
}
