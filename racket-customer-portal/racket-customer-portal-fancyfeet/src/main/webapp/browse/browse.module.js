define(
  [
    'angular',
    'browse/controller/BrowseController',
    'browse/controller/BrowseTypesCtrl'
  ],
  function (angular, BrowseController, BrowseTypesCtrl) {

    angular.module('browse.module', [])

      //.factory('AccountService', AccountService)

      .config(['$stateProvider', function ($stateProvider) {

        $stateProvider
          .state('ff.browse_main', {
            url: 'browse',
            templateUrl: 'browse/view/main.html',
            controller: BrowseController
          })
          
          .state('ff.browse_types', {
            url: 'browse/types',
            templateUrl : 'browse/view/browse_types.html',
            controller: BrowseTypesCtrl
          });

      }]);

  });