import Ember from 'ember';

export default Ember.Route.extend({
  beforeModel: function() {
    let session = this.get('session').fetch().catch(function() {});
    if(session.isAuthenticated) {
      this.transitionTo('user-settings');
    }
  },

  actions: {
    // trigger action from login-component.js
    transitTo() {
      console.log('--> application route transitTo() firing');
      console.log('  -- transitioning to "user-settings"');
      this.transitionTo('user-settings');
    },
  }
});
