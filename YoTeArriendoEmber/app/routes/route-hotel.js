import Route from '@ember/routing/route';

export default Route.extend({
	beforeModel: function() {
		this.get('session').fetch().catch(function() {});
	},
	model() {
		return [];
	},
	model2() {
		return [];
	},
});