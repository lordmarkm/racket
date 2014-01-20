require.config({

    paths: {
        'domReady': '/libs/require/domReady',
        'angular':  '/libs/angular/angular.min',
        "uiRouter": "/libs/angular/angular-ui-router.min",
        'moment' : '/libs/backups/moment.min'
    },

    /**
     * for libs that either do not support AMD out of the box, or
     * require some fine tuning to dependency mgt'
     */
    shim: {
        'angular': {
            exports: 'angular'
        },
        'uiRouter':{
            deps: ['angular']
        },
        'moment': {
        	exports: 'moment'
        }
    },

    deps: [
        // kick start application... see bootstrap.js
        '/javascript/bootstrap.js'
    ]
});