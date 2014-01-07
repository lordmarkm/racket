var racketServices = angular.module('racketServices', []);

racketServices.factory('racketService', function($rootScope) {
	var racketService = {};

	racketService.broadcastNew = function(racket) {
		this.active = racket;
		$rootScope.$broadcast('handleNew');
	}

	return racketService;
});