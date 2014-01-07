var racketApp = angular.module('racketApp', ['ui.router', 'racketServices'])

.config(function($stateProvider) {

	$stateProvider.state('newracket', {
		url: '/newracket',
		templateUrl: '/racket/new',
		controller: 'NewRacketCtrl'
	})
	
	$stateProvider.state('viewracket', {
		url: '/racket/{racketId}',
		templateUrl: '/racket',
		controller: 'RacketCtrl'
	});

});

racketApp.controller('NewRacketCtrl', ['$scope', '$http', 'racketService', function($scope, $http, racketService) {
	$scope.submit = function(){
		$http.post('/racket/new', this.createform).success(function(racket) {
			racketService.broadcastNew(racket);
		});
	}
}]);

racketApp.controller('SidebarCtrl', ['$scope', '$http', 'racketService', function($scope, $http, racketService) {
	$scope.rackets = [];
	
	//load the user's rackets from server
	$http.get('/racket/racketeerinfo').success(function(racketeer) {
		$scope.rackets = $scope.rackets.concat(racketeer.rackets);
	});

	//whenever the user creates a new racket, add that to the sidebar
	$scope.$on('handleNew', function(){
		console.debug('received broadcast. new racket=' + racketService.active);
		$scope.rackets.push(racketService.active);
	});
}]);

racketApp.controller('MainCtrl', ['$scope', function($scope){
	
}]);

racketApp.controller('RacketCtrl', ['$scope', '$stateParams', '$http', function RacketCtrl($scope, $stateParams, $http) {
	$scope.name = "RacketCtrl";
	$scope.racket = {};

	//load the user's rackets from server
	$http.get('/racket/racketinfo/' + $stateParams.racketId).success(function(racket) {
		$scope.racket = racket;
	});
}]);