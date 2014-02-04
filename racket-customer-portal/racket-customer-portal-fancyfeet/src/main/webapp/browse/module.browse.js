define(
  [
    'angular'
  ],
  function (angular) {

    angular.module('browse.module', [])

      //.factory('AccountService', AccountService)

      .config(['$stateProvider', function ($stateProvider) {

        $stateProvider
          .state('browse.main', {
            url: 'browse',
            templateUrl: 'browse/main.html',
            controller: BrowseMainController
          });

      }]);

  });