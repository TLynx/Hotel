/**
 * Created by Администратор on 23.02.2016.
 */
var application = angular.module('appp', ['ngResource']);
application.controller("reservController",function($scope, $resource) {
    var Reservs  = $resource('/api/reservation');
    var reservs = Reservs.query(function() {
        $scope.reservs=reservs;
    });


});