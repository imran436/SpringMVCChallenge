var app = new Vue({
   el: '#app',
   data: {
      userlist: [],
      edituser: false,
      adduser: false
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
         });
      },
      newUser() {
         this.edituser = false;
         this.adduser = {
            userName: '',
            firstName: '',
            lastName: ''
         };
      },
      createUser() {
         axios.post('/users', this.adduser).then(response => {
            this.adduser = false;
         });
      }
   }
});
