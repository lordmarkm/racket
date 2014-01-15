define(['/javascript/controllers/module.js'], function (controllers) {
  'use strict';

  controllers.controller('RacketOperationsCtrl', ['$scope', '$http', '$stateParams', function($scope, $http, $stateParams) {

	  $scope.name = 'RacketOperationsCtrl';
      $scope.racket = {};
      $scope.racketId = $stateParams.racketId;

      $scope.commodities = {};
      $scope.sellforms = {};
      $scope.restockforms = {};

      $http.get('/racket/racketinfo/' + $stateParams.racketId).success(function(racket) {
		$scope.racket = racket;
		for (var i in $scope.racket.commodities) {
	    	var id = $scope.racket.commodities[i].id;
	    	$scope.commodities[id] = $scope.racket.commodities[i];
	    	$scope.sellforms[id] = {};
	    	$scope.restockforms[id] = {};
	    	console.debug(JSON.stringify($scope.sellforms));
	    }
	  });

      //handle sell ops
      $scope.submitSellForm = function(id) {

    	  var form = $scope.sellforms[id];
    	  console.debug('sell! ' + JSON.stringify($scope.sellforms[id]));
    	  $scope.commodities[id].stock += parseInt($scope.sellforms[id].sold);
      }
      
      //handle restock ops
      $scope.submitRestockForm = function(id) {
    	  
      }
  }]);
  
});

