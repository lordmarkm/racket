define(['/javascript/controllers/module.js'], function (controllers) {
  'use strict';

  controllers.controller('ManageRacketCtrl', ['$scope', '$http', '$stateParams', 'RacketService', function($scope, $http, $stateParams, racketService) {
	  
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
    	});
      }

      $scope.submitNewCommodity = function() {
    	  this.newCommodity.racketId = $scope.racketId;
    	  $http.post('/commodity/new', this.newCommodity).success(function(commodity) {
    		  $scope.racket.commodities.push(commodity);
    	  });
      }
  }]);
  
});

