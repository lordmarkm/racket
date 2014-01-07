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
		controller: RacketCtrl
	});

});

racketApp.controller('NewRacketCtrl', ['$scope', '$http', 'racketService', function($scope, $http, racketService) {
	$scope.submit = function(){
		$http.post('/racket/new', this.createform).success(function(racket) {
			racketService.broadcastNew(racket);
		});
	}
}]);

racketApp.controller('SidebarCtrl', ['$scope', 'racketService', function($scope, racketService) {
	$scope.rackets = [];
	$scope.$on('handleNew', function(){
		console.debug('received broadcast. new racket=' + racketService.active);
		$scope.rackets.push(racketService.active);
	});
}]);

function MainCtrl($scope) {
}

function RacketCtrl($scope, $stateParams) {
	$scope.name = "RacketCtrl";
	$scope.params = $stateParams;
	
	console.debug(JSON.stringify($stateParams));
}