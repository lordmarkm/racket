define(['/javascript/app.js'], function(app) {
    'use strict';
    
    return app.config(function($stateProvider) {
    	$stateProvider.state('home', {
    		url: '/',
    		templateUrl: '/index'
    	});
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
    	$stateProvider.state('manageracket', {
    		url: '/racket/manage/{racketId}',
    		templateUrl: '/racket/manage',
    		controller: 'ManageRacketCtrl'
    	});
    	$stateProvider.state('racketops', {
    		url: '/racket/operations/{racketId}',
    		templateUrl: '/racketoperations',
    		controller: 'RacketOperationsCtrl'
    	});
    	$stateProvider.state('racketnotifs', {
    		url: '/racket/notifs/{racketId}',
    		templateUrl: '/racket/notifs',
    		controller: 'RacketNotifsCtrl'
    	});
    	//commodity states
    	$stateProvider.state('editcommodity', {
    		url: '/commodity/edit/{racketId}/{commodityId}',
    		templateUrl: '/commodity/edit',
    		controller: 'CommodityEditCtrl'
    	});
    });

});