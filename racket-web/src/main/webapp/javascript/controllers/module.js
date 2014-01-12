define(['angular'], function (ng) {
    'use strict';

    var controllers = ng.module('app.controllers', []);

    controllers.constant('commodityTypes', ['RETAIL', 'RENTAL']);

    return controllers;
});