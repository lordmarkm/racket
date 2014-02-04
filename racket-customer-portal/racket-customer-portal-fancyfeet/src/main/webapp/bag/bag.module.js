define(
  [
    'angular',
    'bag/controller/BagCtrl'
  ],
  function (angular, BagCtrl) {

    angular.module('bag.module', [])
      .config(['$stateProvider', function ($stateProvider) {

        $stateProvider
          .state('ff.bag', {
            url: 'bag',
            templateUrl: 'bag/view/bag.html',
            controller: BagCtrl
          });

      }]);

  });