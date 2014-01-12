define(['/javascript/controllers/module.js'], function (controllers) {
  'use strict';

  controllers.controller('CommodityEditCtrl', ['$scope', '$http', '$stateParams', 'commodityTypes', function($scope, $http, $stateParams, commodityTypes) {

	  $scope.name = 'CommodityEditCtrl';
      $scope.commodityId = $stateParams.commodityId;
      $scope.editCommodity = {};
      $scope.commodityTypes = commodityTypes;

      $http.get('/commodity/commodityinfo/' + $stateParams.commodityId).success(function(commodity) {
		setCommodity(commodity);
      });
      
      $scope.submitEditCommodity = function() {
    	  this.editCommodity.racketId = $stateParams.racketId;
    	  console.debug('About to submit edit commodity request: ' + JSON.stringify(this.editCommodity));
    	  $http.post('/commodity/edit', this.editCommodity).success(function(commodity) {
    		  setCommodity(commodity);
    	  });
     }
      
     function setCommodity(commodity) {
        $scope.commodity = commodity;
 	    $scope.editCommodity = {
 	 	      racketId : $stateParams.racketId,
 	 	      id : $stateParams.commodityId,
 	 	      name : commodity.name,
 	 	      description : commodity.description,
 	 	      price : commodity.price,
 	 	      unit : commodity.unit,
 	 	      type : commodity.type
 	    };
     }
  }]);
  
});

