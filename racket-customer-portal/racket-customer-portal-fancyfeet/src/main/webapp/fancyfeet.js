require.config({
  baseUrl: '/',
  paths: {
    'angular': 'libs/angular/angular.min',
    'angular-ui-router': 'libs/angular/angular-ui-router.min'
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
  'angular-ui-router',
  'browse/browse.module',
  'common/commons.module',
  'bag/bag.module'
], function (angular) {

  angular.element().ready(function () {

    var main = angular.module('init', [])
      .config(['$stateProvider', function ($stateProvider) {
        $stateProvider.state('ff', {
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
      'init',
      'browse.module',
      'commons.module',
      'bag.module'
    ]);
  });
});