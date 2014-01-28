define(['/javascript/controllers/module.js', 'moment'], function (controllers, moment) {
    'use strict';
    
    controllers.controller('RacketTransactionsCtrl', ['$scope', '$stateParams', '$http', function RacketTransactionsCtrl($scope, $stateParams, $http) {
    	$scope.name = "RacketTransactionsCtrl";
    	$scope.racket = {};

    	$http.get('/racket/racketinfo/' + $stateParams.racketId).success(function(racket) {
    		$scope.racket = racket;
    	});

    	$scope.transactions = {};
    	$scope.annotationforms = {};
    	$scope.showDetails = {};
    	$scope.showAnnotations = {};
    	$scope.showAnnotationForm = {};
    	$scope.start = 0;
    	$scope.end = 10;
    	$http.get('/racket/transactions/' + $stateParams.racketId + '/' + $scope.start + '/' + $scope.end).success(function(transactions) {
    		//$scope.transactions = transactions;
    		var transaction;
    		for(var i in transactions) {
    			transaction = transactions[i];
    			$scope.transactions[transaction.id] = transaction;
    			$scope.annotationforms[transactions[i].id] = {};
    		}
    	});
    	
    	$scope.orderedTransactions = function() {
    		var ordered = [];
    		for(var i in $scope.transactions) {
    			ordered.push($scope.transactions[i]);
    		}
    		return ordered;
    	}
    	
    	$scope.addAnnotation = function(id) {
			console.debug('About to post: ' + JSON.stringify($scope.annotationforms[id]));
    		$http.post('/racket/transactions/annotations/add/' + id, $scope.annotationforms[id]).success(function(annotation) {
    			$scope.transactions[id].annotations.push(annotation);
    			$scope.annotationforms[id] = {};
    		});
    	}

    	$scope.fromNow = function(date) {
    		return moment(date).fromNow();
    	}
    }]);
});

