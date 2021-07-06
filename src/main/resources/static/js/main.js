var app = new Vue({
   el: '#app',
   data: {
      userlist: [],
      edituser: false,
      adduser: false,
      deleteuser: false,
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
         if(this.validateEmail(this.adduser.email)){
         axios.post('/users', this.adduser).then(response => {
            this.adduser = false;
            this.userlist = response.data;
            
         });
      }
      },
      deleteUser(userId) {
         axios.delete('/users/'+userId).then(response => {
            this.listUsers();
         });
      },
      validateEmail(userEmail){
         var atpos = userEmail.indexOf("@");
         var dotpos = userEmail.lastIndexOf(".");
         if (atpos < 1 || ( dotpos - atpos < 2 ))
         {
            alert("Please enter correct email ID")
            return false;
         }
         return true;
      }
   }
});
