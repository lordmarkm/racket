define(['/javascript/controllers/module.js', 'moment'], function (controllers, moment) {
    'use strict';
    
    controllers.controller('RacketTransactionsCtrl', ['$scope', '$stateParams', '$http', function RacketTransactionsCtrl($scope, $stateParams, $http) {
    	$scope.name = "RacketTransactionsCtrl";
    	$scope.racket = {};

    	$http.get('/racket/racketinfo/' + $stateParams.racketId).success(function(racket) {
    		$scope.racket = racket;
    	});
    	
    	$scope.transactions = {};
    	$scope.start = 0;
    	$scope.end = 10;
    	$http.get('/racket/transactions/' + $stateParams.racketId + '/' + $scope.start + '/' + $scope.end).success(function(transactions) {
    		$scope.transactions = transactions;
    	});
    	
    	$scope.fromNow = function(date) {
    		return moment(date).fromNow();
    	}
    }]);
});

