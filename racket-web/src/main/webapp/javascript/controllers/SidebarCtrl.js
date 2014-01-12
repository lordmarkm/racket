define(['/javascript/controllers/module.js'], function (controllers) {
    'use strict';
    
    controllers.controller('SidebarCtrl', ['$scope', '$http', 'RacketService', function($scope, $http, racketService) {
    	$scope.rackets = [];
    	
    	//load the user's rackets from server
    	$http.get('/racket/racketeerinfo').success(function(racketeer) {
    		$scope.rackets = $scope.rackets.concat(racketeer.rackets);
    	});

    	//whenever the user creates a new racket, add that to the sidebar
    	$scope.$on('handleNew', function(){
    		console.debug('received broadcast. new racket=' + JSON.stringify(racketService.active));
    		$scope.rackets.push(racketService.active);
    	});
    	
    	//whenever the user deletes a racket, remove it form the sidebar
    	$scope.$on('handleDelete', function() {
    		for(var i in $scope.rackets) {
    			if($scope.rackets[i].id == racketService.active) {
    				$scope.rackets.splice(i, 1);
    			}
    		}
    	});
    }]);
});

