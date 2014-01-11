define(['/javascript/controllers/module.js'], function (controllers) {
	'use strict';

	controllers.controller('NewRacketCtrl', ['$scope', '$http', '$state', 'RacketService', function($scope, $http, $state, racketService) {
	    $scope.submit = function() {
		    $http.post('/racket/new', this.createform).success(function(racket) {
		        racketService.broadcastNew(racket);
		        $state.go('viewracket', {'racketId': racket.id});
	        });
	    }
	}]);
});

