define(function () {

  return ['$scope', '$stateParams', '$http', 'racketIds', function ($scope, $stateParams, $http, racketIds) {

    $scope.racketIds = racketIds;
    $scope.controllerName = 'BrowseController';

  }];
});