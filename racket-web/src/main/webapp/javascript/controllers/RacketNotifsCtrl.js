define(['/javascript/controllers/module.js'], function (controllers) {
    'use strict';
    
    controllers.controller('RacketNotifsCtrl', ['$scope', '$stateParams', '$http', function RacketNotifsCtrl($scope, $stateParams, $http) {
    	$scope.name = "RacketNotifsCtrl";
    	$scope.racket = {};

    	$http.get('/racket/racketinfo/' + $stateParams.racketId).success(function(racket) {
    		$scope.racket = racket;
    	});
    	
    	$scope.notifs = {};
    	$scope.start = 0;
    	$scope.end = 10;
    	$http.get('/racket/notifs/' + $stateParams.racketId + '/' + $scope.start + '/' + $scope.end).success(function(notifs) {
    		$scope.notifs = notifs;
    	});
    }]);
});

