import Component from '@ember/component';
import { inject as service } from '@ember/service';

export default Component.extend({
	session: service(),
	store: service(),
	
	createUpdateUser() {
		if(this.get('session.isAuthenticated')) {
			let store = this.get('store');
			let uid = this.get('session.currentUser.uid');
			let timeStamp = Date.now();
			store.findRecord('setting', 0)
				.then((result) => {
					result.set('lastLogin', timeStamp);
					result.save();
				})
				.catch((error) => {
					if(error.message.includes('no record was found at')) {
						let newUser = store.createRecord('user', {
							id: uid,
							settings: { 0: { "lastLogin": timeStamp, "theme": "light", "fontSize": 10 } },
						});
						newUser.save();
					}
				});
		}
	},

	actions: {
		signIn: function(provider) {
			this.get('session')
				.open('firebase', { provider: provider })
				.then(() => {
					this.createUpdateUser();
					this.triggerAction({ action: 'transitToProfile', target: this.get('route') } );
				})
				.catch(function(error) {
					alert(error);
				});
		},
		
		signOut: function() {
			this.get('session')
				.close().then(() => {
					this.triggerAction({ action: 'transitToInicio', target: this.get('route') } );
				});
		},
	}
});