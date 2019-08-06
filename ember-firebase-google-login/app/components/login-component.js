import Ember from 'ember';

export default Ember.Component.extend({
  session: Ember.inject.service(),
  store: Ember.inject.service(),

  createUpdateUser() {
    console.log('--> createUpdateUser() firing');
    if(this.get('session.isAuthenticated')) {
      let store = this.get('store');
      let uid = this.get('session.currentUser.uid');
      let timeStamp = Date.now();
      store.findRecord('setting', 0)
           .then((result) => {
             console.log(' -- updating lastLogin timestamp');
             result.set('lastLogin', timeStamp);
             result.save();
           })
           .catch((error) => {
             console.log(' -- createUpdateUser error.message');
             console.log(error.message);
             if(error.message.includes('no record was found at')) {
               console.log(' -- creating new user with default values');
               let newUser = store.createRecord('user', {
                 id: uid,
                 // Enter new user defaults here:
                 settings: { 0: { "lastLogin": timeStamp, "theme": "light", "fontSize": 10 } },
               });
               newUser.save();
             }
           });
    }
  },

  actions: {
    signIn: function(provider) {
      console.log('--> signIn() firing');
      this.get('session').open('firebase', { provider: provider }).then(() => {
        // Uncomment the 2 lines below to see what Google login returns.
        // console.log(' -- data.currentUser returned from Firebase authentication');
        // console.log(data.currentUser);
        this.createUpdateUser();
        console.log(' -- triggerAction transitTo()');
        this.triggerAction({ action: 'transitTo', target: this.get('route') } );
      }).catch(function(error) {
        console.log(' -- signIn error.message:');
        console.log(error.message);
      });
    },
    signOut: function() {
      console.log('--> signOut() firing');
      this.get('session').close().then(() => {
        console.log(' -- triggerAction transitTo()');
        this.triggerAction({ action: 'transitTo', target: this.get('route') } );
      });
    },
  }
});
