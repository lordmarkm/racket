define(['/javascript/controllers/module.js'], function (controllers) {
  'use strict';

  controllers.controller('RacketOperationsCtrl', ['$scope', '$http', '$stateParams', function($scope, $http, $stateParams) {
	  
	  $scope.name = 'RacketOperationsCtrl';
      $scope.racket = {};
      $scope.racketId = $stateParams.racketId;
      
      $http.get('/racket/racketinfo/' + $stateParams.racketId).success(function(racket) {
		$scope.racket = racket;
	  });
      
  }]);
  
});
