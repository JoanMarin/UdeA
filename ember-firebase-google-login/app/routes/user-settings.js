import Ember from 'ember';

export default Ember.Route.extend({
  beforeModel: function() {
    let session = this.get('session').fetch().catch(function() {});
    if(!session.isAuthenticated) {
      this.transitionTo('application');
    }
  },

  model() {
    console.log('--> user-settings route model() firing');
    return this.store.find('setting', 0);
  },
});
