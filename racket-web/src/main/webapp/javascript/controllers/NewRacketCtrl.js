define(['/javascript/controllers/module.js'], function (controllers) {
	'use strict';

	controllers.controller('NewRacketCtrl', ['$scope', '$http', 'RacketService', function($scope, $http, racketService) {
	    $scope.submit = function() {
		    $http.post('/racket/new', this.createform).success(function(racket) {
		        racketService.broadcastNew(racket);
	        });
	    }
	}]);
});

