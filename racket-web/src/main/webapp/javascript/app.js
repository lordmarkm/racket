define([
    'angular',
    'uiRouter',
    '/javascript/controllers/index.js',
    //'/javascript/services/index.js'
], function (ng) {
    'use strict';

    return ng.module('app', [
        //'app.services',
        'app.controllers',
        'ui.router'
    ]);
});