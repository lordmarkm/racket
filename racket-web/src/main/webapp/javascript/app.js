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

racketApp.controller('NewRacketCtrl', function($scope) {
	$scope.submit = function(){
		console.debug('about to submit. name=' + this.name + ', desc=' + this.desc);
	}
});

function MainCtrl($scope) {
}

function RacketCtrl($scope, $stateParams) {
	$scope.name = "RacketCtrl";
	$scope.params = $stateParams;
	
	console.debug(JSON.stringify($stateParams));
}