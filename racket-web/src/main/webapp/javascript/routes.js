define(['/javascript/app.js'], function(app) {
    'use strict';
    
    return app.config(function($stateProvider) {
    	$stateProvider.state('newracket', {
    		url: '/newracket',
    		templateUrl: '/racket/new',
    		controller: 'NewRacketCtrl'
    	});
    	$stateProvider.state('viewracket', {
    		url: '/racket/{racketId}',
    		templateUrl: '/racket',
    		controller: 'RacketCtrl'
    	});
    });

});