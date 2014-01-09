define(['/javascript/controllers/module.js'], function (controllers) {
    'use strict';
    
    controllers.controller('SidebarCtrl', ['$scope', '$http', function($scope, $http) {
    	$scope.rackets = [];
    	
    	//load the user's rackets from server
    	$http.get('/racket/racketeerinfo').success(function(racketeer) {
    		$scope.rackets = $scope.rackets.concat(racketeer.rackets);
    	});

    	//whenever the user creates a new racket, add that to the sidebar
    	//$scope.$on('handleNew', function(){
    	//	console.debug('received broadcast. new racket=' + racketService.active);
    	//	$scope.rackets.push(racketService.active);
    	//});
    }]);
});

