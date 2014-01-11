define(['/javascript/controllers/module.js'], function (controllers) {
    'use strict';
    
    controllers.controller('RacketCtrl', ['$scope', '$stateParams', '$http', function RacketCtrl($scope, $stateParams, $http) {
    	$scope.name = "RacketCtrl";
    	$scope.racket = {};

    	$http.get('/racket/racketinfo/' + $stateParams.racketId).success(function(racket) {
    		$scope.racket = racket;
    	});
    }]);
});

