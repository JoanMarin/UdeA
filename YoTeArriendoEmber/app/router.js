import EmberRouter from '@ember/routing/router';
import config from './config/environment';

const Router = EmberRouter.extend({
	location: config.locationType,
	rootURL: config.rootURL
});

Router.map(function() {
	this.route('route-inicio', {path: '/inicio'});
	this.route('route-hotel', {path: '/hotels'});
	this.route('route-profile', {path:'/profile'});
	this.route('route-booking', {path:'/booking'});
});

export default Router;