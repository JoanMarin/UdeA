import Route from '@ember/routing/route';

export default Route.extend({
	beforeModel: function() {
		this.get('session').fetch().catch(function() {});
	},
	actions: {
		transitToInicio() {
			this.transitionTo('route-inicio');
		},
		transitToProfile() {
			this.transitionTo('route-profile');
		}
	}
});