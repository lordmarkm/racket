define(['/javascript/services/module.js'], function (services) {
    'use strict';
    
    services.service('RacketService', function($rootScope) {
    	var racketService = {};

    	racketService.broadcastNew = function(racket) {
    		console.debug('received new racket: ' + JSON.stringify(racket));
    		this.active = racket;
    		$rootScope.$broadcast('handleNew');
    	}

    	return racketService;
    });
});