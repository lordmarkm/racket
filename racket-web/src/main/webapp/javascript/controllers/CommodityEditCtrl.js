define(['/javascript/controllers/module.js'], function (controllers) {
  'use strict';

  controllers.controller('CommodityEditCtrl', ['$scope', '$http', '$stateParams', 'commodityTypes', 'roundUpTypes', function($scope, $http, $stateParams, commodityTypes, roundUpTypes) {

	  $scope.name = 'CommodityEditCtrl';
      $scope.commodityId = $stateParams.commodityId;
      $scope.editCommodity = {
        type : 'RETAIL'		  
      };
      $scope.commodityTypes = commodityTypes;
      $scope.roundUpTypes = roundUpTypes;

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
 	 	      type : commodity.type,
 	 	      chargingMethod: commodity.chargingMethod,
 	 	      pricePerMinute: commodity.pricePerMinute,
 	 	      roundUp: commodity.roundUp,
 	 	      minimumCharge: commodity.minimumCharge,
 	 	      images: commodity.images
 	    };
     }
     
     $scope.newImage = {};
     $scope.addImage = function() {
       $http.post('/image/commodity/' + $scope.commodityId, $scope.newImage).success(function(image){
         $scope.commodity.images.push(image);
         $scope.editCommodity.images.push(image);
       });
     }
     
     $scope.done = function(){
    	 history.back();
     }
  }]);
  
});

