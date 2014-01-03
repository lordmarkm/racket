require.config({
  baseUrl: '/',
  paths: {
    'angular': '//ajax.googleapis.com/ajax/libs/angularjs/1.2.6/angular.min',
    'jquery': '//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min',
  }
});

require(['jquery', 'angular'], function($, angular) {

	angular.element().ready(function(){
		
		angular.bootstrap(document);
		
	});

});