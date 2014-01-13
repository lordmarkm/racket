define(['/javascript/controllers/module.js'], function (controllers) {
  'use strict';

  controllers.controller('ManageRacketCtrl', ['$scope', '$http', '$state', '$stateParams', 'RacketService', function($scope, $http, $state, $stateParams, racketService) {
	  
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

      $scope.commodityTypes = ['RENTAL', 'RETAIL'];
      $scope.submitNewCommodity = function() {
    	  this.newCommodity.racketId = $scope.racketId;
    	  console.debug('About to submit new commodity request: ' + JSON.stringify(this.newCommodity));
    	  $http.post('/commodity/new', this.newCommodity).success(function(commodity) {
    		  $scope.racket.commodities.push(commodity);
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
  }]);
  
});

