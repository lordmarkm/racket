define(['/javascript/controllers/module.js'], function (controllers) {
  'use strict';

  controllers.controller('ManageRacketCtrl', ['$scope', '$http', '$state', '$stateParams', 'RacketService', 'commodityTypes', function($scope, $http, $state, $stateParams, racketService, commodityTypes) {
	  
	  $scope.name = 'ManageRacketCtrl';
      $scope.racket = {};
      $scope.racketId = $stateParams.racketId;
      
      $http.get('/racket/racketinfo/' + $stateParams.racketId).success(function(racket) {
		$scope.racket = racket;
	  });
      
      $scope.deleteRacket = function() {
    	if(!confirm('Are you sure?')) return false;
    	$http.post('/racket/delete/' + $stateParams.racketId).success(function() {
    		console.debug('racket deleted!');
    		racketService.broadcastDelete($scope.racketId);
    		$state.go('home');
    	});
      }

      $scope.commodityTypes = commodityTypes;
      $scope.newCommodity = {
    	  type: 'RETAIL'
      }
      $scope.submitNewCommodity = function() {
    	  this.newCommodity.racketId = $scope.racketId;
    	  console.debug('About to submit new commodity request: ' + JSON.stringify(this.newCommodity));
    	  $http.post('/commodity/new', this.newCommodity).success(function(commodity) {
    		  $scope.racket.commodities.push(commodity);
    		  $scope.newCommodity = {type:'RETAIL'};
    	  });
      }
      
      $scope.deleteCommodity = function(commodity) {
    	  if(!confirm('Are you sure you want to delete ' + commodity.name + '?')) return false;
    	  $http.post('/commodity/delete/' + commodity.id).success(function(){
    		  console.debug($scope.racket.commodities);
    		  var index = $scope.racket.commodities.indexOf(commodity);
    		  console.debug('found index: ' + index);
    		  if (index != -1) {
    			  $scope.racket.commodities.splice(index, 1);
    		  }
    	  });
      }
      
      $scope.classifications = [];
      $http.get('/racket/expenses/classifications/' + $scope.racketId).success(function(classifications) {
    	 $scope.classifications = classifications; 
      });
      
      $scope.newExpense = {};
      $scope.submitNewExpense = function() {
    	  if ($scope.newExpense.newClassification && $scope.newExpense.newClassification != $scope.newExpense.classification) {
    		  $scope.classifications.push($scope.newExpense.newClassification);
    		  $scope.newExpense.classification = $scope.newExpense.newClassification;
    		  delete $scope.newExpense.newClassification;
    	  }
    	  console.debug('About to submit new expense: ' + JSON.stringify($scope.newExpense));
    	  $http.post('/racket/expenses/' + $scope.racketId, this.newExpense).success(function(notif) {
    		  $scope.notif = notif;
    		  $scope.newExpense = {};
    	  });    	  
      }
  }]);
  
});

