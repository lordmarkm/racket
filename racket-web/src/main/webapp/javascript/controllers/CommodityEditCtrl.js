define(['/javascript/controllers/module.js'], function (controllers) {
  'use strict';

  controllers.controller('CommodityEditCtrl', ['$scope', '$http', '$stateParams', function($scope, $http, $stateParams) {

	  $scope.name = 'CommodityEditCtrl';
      $scope.racket = {};
      $scope.commodityId = $stateParams.commodityId;

      $http.get('/commodity/commodityinfo/' + $stateParams.commodityId).success(function(commodity) {
		$scope.commodity = commodity;
	  });

      $scope.commodityTypes = ['RENTAL', 'RETAIL'];
  }]);
  
});

