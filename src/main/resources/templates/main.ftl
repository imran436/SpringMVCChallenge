<!DOCTYPE HTML>
<html>
   <head>
      <title>User Microservice</title>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
      <script src="js/axios.min.js"></script>
      <script src="js/vue.js"></script>
      <link type="text/css" rel="stylesheet" href="css/main.css" />
      <link href="https://fonts.googleapis.com/css?family=Do+Hyeon" rel="stylesheet" />
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
   </head>
   <body>
      <div id="app">
         <div class="userlist">
            <table v-if="userlist.length">
               <thead>
                  <tr>
                     <td>User ID</td>
                     <td>User name</td>
                     <td>First name</td>
                     <td>Last name</td>
                     <td> Email </td>
                     <td>Actions</td>
                  </tr>
               </thead>
               <tbody>
                  <tr v-for="(user, index) in userlist">
                     <td>{{user.id}}</td>
                     <td>{{user.userName}}</td>
                     <td>{{user.firstName}}</td>
                     <td>{{user.lastName}}</td>
                     <td>{{user.email}}</td>
                     <td><a href="#" v-on:click="editUser(user.id)">Edit</a></td>
                     <td><a href="#" v-on:click="confirmDeleteUser(user.id)">Delete</a></td>
                  </tr>
               </tbody>
            </table>
            <button type="button" v-on:click="newUser">Create new user</button>
         </div>
         <div class="edituser" v-if="edituser">
            <dl>
               <dt>User ID</dt>
               <dd>{{edituser.id}}</dd>
               <dt>User name</dt>
               <dd><input type="text" name="userName" v-model="edituser.userName" /></dd>
               <dt>First name</dt>
               <dd><input type="text" name="firstName" v-model="edituser.firstName" /></dd>
               <dt>Last name</dt>
               <dd><input type="text" name="lastName" v-model="edituser.lastName" /></dd>
               <dt>Email</dt>
               <dd><input type="email" name="email" v-model="edituser.email" required /></dd>
            </dl>
            <button type="button" v-on:click="saveUser">Save user</button>
         </div>
         <div class="adduser" v-if="adduser">
            <dl>
               <dt>User name</dt>
               <dd><input type="text" name="userName" v-model="adduser.userName" /></dd>
               <dt>First name</dt>
               <dd><input type="text" name="firstName" v-model="adduser.firstName" /></dd>
               <dt>Last name</dt>
               <dd><input type="text" name="lastName" v-model="adduser.lastName" /></dd>
               <dt>Email</dt>
               <dd><input type="text" name="email" v-model="adduser.email" /></dd>
            </dl>
            <button type="button" v-on:click="createUser">Create user</button>
         </div>
         <div class="confirmdeleteuser" v-if="confirmdeleteuser">
            <dl>
            <h1>Are you sure you want to Delete User?</h1>
               <dt>User ID</dt>
               <dd>{{confirmdeleteuser.id}}</dd>
               <dt>User name</dt>
               <dd>{{confirmdeleteuser.userName}}</dd>
               <dt>First name</dt>
               <dd>{{confirmdeleteuser.firstName}}</dd>
               <dt>Last name</dt>
               <dd>{{confirmdeleteuser.lastName}}</dd>
               <dt>Email</dt>
               <dd>{{confirmdeleteuser.email}}</dd>
            </dl>
            <button type="button" v-on:click="deleteUser(confirmdeleteuser.id)">Delete User</button>
         </div>
      </div>
      <script src="js/main.js" type="module"></script>
   </body>
</html>