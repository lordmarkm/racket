var racketApp = angular.module('racketApp', ['ui.router'])

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

racketApp.controller('NewRacketCtrl', function($scope, $http) {
	$scope.submit = function(){
		$http.post('/racket/new', this.createform).success(function(racket) {
			
		});
	}
});

racketApp.controller('SidebarCtrl', ['$scope', 'racketService'], function($scope, racketService) {
	
});

function MainCtrl($scope) {
}

function RacketCtrl($scope, $stateParams) {
	$scope.name = "RacketCtrl";
	$scope.params = $stateParams;
	
	console.debug(JSON.stringify($stateParams));
}