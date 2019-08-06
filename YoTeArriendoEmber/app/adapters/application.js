import Ember from 'ember';
import FirebaseAdapter from 'emberfire/adapters/firebase';

export default FirebaseAdapter.extend({
	pathForType(type) {
		if(type === 'user') {
			return `users`;
		} 
		else {
			let uid = this.get('session.currentUser.uid');
			let path = Ember.String.pluralize(type);
			return  `users/${uid}/${path}`;
		}
	}
});
