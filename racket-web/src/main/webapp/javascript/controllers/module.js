define(['angular'], function (ng) {
    'use strict';

    var controllers = ng.module('app.controllers', []);

    //These are represented as enums on the java side
    controllers.constant('commodityTypes', ['RETAIL', 'RENTAL']);
    controllers.constant('roundUpTypes', ['NONE', 'NEXT_HALF_HOUR', 'NEXT_HOUR', 'NEXT_DAY']);

    return controllers;
});