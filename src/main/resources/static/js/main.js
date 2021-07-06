var app = new Vue({
   el: '#app',
   data: {
      userlist: [],
      edituser: false,
      adduser: false,
      confirmdeleteuser: false,
   },
   mounted: function () {
      this.listUsers();
   },
   methods: {
      listUsers() {
         axios.get('/users').then(response => {
            this.userlist = response.data;
         });
      },
      editUser(userId) {
         axios.get('/users/' + userId).then(response => {
            this.adduser = false;
            this.edituser = response.data;
            
         });
      },
      saveUser() {
         axios.put('/users/' + this.edituser.id, this.edituser).then(response => {
            this.edituser = false;
            this.listUsers();
         });
      },
      newUser() {
         this.edituser = false;
         this.adduser = {
            userName: '',
            firstName: '',
            lastName: '',
            email:''
         };
      },
      createUser() {
         if(this.validateUser(this.adduser)){
         axios.post('/users', this.adduser).then(response => {
            this.adduser = false;
            this.userlist = response.data;
            
         });
      }
      },
      confirmDeleteUser(userId){
         this.confirmdeleteuser = this.userlist.find(user =>user.id === userId);

      },
      deleteUser(userId) {
         axios.delete('/users/'+userId).then(response => {
            this.confirmdeleteuser = false;
            this.userlist = response.data;
         });
      },
      validateUser(validateduser){
         var atpos = validateduser.email.indexOf("@");
         var dotpos = validateduser.email.lastIndexOf(".");
         var msg = "";
         if(this.userlist.find(user =>user.userName === validateduser.userName) !=null){
            msg +="Username is already in use /n"
         }
         if(this.userlist.find(user =>user.email === validateduser.email) !=null){
            msg +="Email is already in use /n"
         }
         else if(atpos < 1 || ( dotpos - atpos < 2 ))
         {
            msg +="Please enter a correct email address /n"
         }
         if(msg != ""){
            alert(msg);
         }
         return true;
      }
   }
});
