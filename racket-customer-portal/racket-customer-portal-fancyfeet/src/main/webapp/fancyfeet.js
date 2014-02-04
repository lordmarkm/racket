require.config({
  baseUrl: '/',
  paths: {
    'angular': 'lib/angular/angular.min',
    'angular-ui-router': 'lib/angular/angular-ui-router.min'
  },
  shim: {
    'angular': {
      exports: 'angular'
    },
    'angular-ui-router': {
      deps: ['angular']
    }
  }
});

require([
  'angular',
  'angular-ui-router'
], function (angular) {

  angular.element().ready(function () {

    var main = angular.module('init', [])
      .config(['$stateProvider', function ($stateProvider) {
        $stateProvider.state('main', {
          url: '/',
          controller: 'MainCtrl',
          templateUrl: 'fancyfeet.html'
        });
      }]);

    main.controller('MainCtrl', ['$scope', function($scope) {
      $scope.controllerName = 'MainCtrl';
    }]);

    angular.bootstrap(document, [
      'ui.router',
      'init'
    ]);
  });
});