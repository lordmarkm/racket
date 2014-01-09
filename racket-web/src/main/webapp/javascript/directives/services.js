var racketServices = angular.module('racketServices', []);

racketServices.factory('racketService', function($rootScope) {
	var racketService = {};

	racketService.broadcastNew = function(racket) {
		console.debug('received new racket: ' + JSON.stringify(racket));
		this.active = racket;
		$rootScope.$broadcast('handleNew');
	}

	return racketService;
});