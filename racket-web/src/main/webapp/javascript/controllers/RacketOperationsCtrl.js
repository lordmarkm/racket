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
	    	$scope.sellforms[id] = {
	    		sold : 1	
	    	};
	    	$scope.restockforms[id] = {
	    		restocked : 1
	    	};
	    }
	  });

      //handle sell ops
      $scope.submitSellForm = function(id) {
    	  var commodity = $scope.commodities[id];
    	  var form = $scope.sellforms[id];
    	  
    	  if(commodity.stock < form.sold) {
    		  alert('Not enough stock to sell that much!');
    		  return false;
    	  }
    	  
    	  $http.post('/commodity/sold/' + id + '/' + form.sold).success(function(){
        	  $scope.commodities[id].stock -= parseInt($scope.sellforms[id].sold);
    	  });
      }
      
      //handle restock ops
      $scope.submitRestockForm = function(id) {
    	  var commodity = $scope.commodities[id];
    	  var form = $scope.restockforms[id];
    	  
    	  $http.post('/commodity/restock/' + id + '/' + form.restocked).success(function(){
    		  $scope.commodities[id].stock += parseInt($scope.restockforms[id].restocked);
    	  });
      }
  }]);
  
});

