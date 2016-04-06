/**
 * Created by ihor on 06.04.2016.
 */
var application = angular.module('appp', ['ngResource']);
application.controller("reservController",function($scope, $resource) {
    var Reservs  = $resource('/api/reservation/all');
    var reservs = Reservs.query(function() {
        $scope.reservs=reservs;
        console.log($scope.reservs);
    });
    $scope.dataTransform=function(data){
        var date = new Date(data);
        var dateToStr = date.toUTCString().split(' ');
        var cleanDate = dateToStr[1] + ' ' + dateToStr[2] + ' ' + dateToStr[3] ;
        return cleanDate;
    };

});