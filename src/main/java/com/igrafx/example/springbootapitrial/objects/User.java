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

   @JsonCreator
   public User(
           @JsonProperty("id") int id,
           @JsonProperty("userName") String userName,
           @JsonProperty("firstName") String firstName,
           @JsonProperty("lastName") String lastName
   )
   {
      this.userName = userName;
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
   }
   
   public User(int id, User user)
   {
      this(id, user.userName, user.firstName, user.lastName);
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

}
