/**
 * Created by Администратор on 23.02.2016.
 */
var application = angular.module('appp', ['ngResource']);
application.controller("reservController",function($scope, $resource) {
    var Reservs  = $resource('/api/reservation',{},{update : {method:"PUT"}});
    var reservs = Reservs.query(function() {
        $scope.reservs=reservs;
        console.log($scope.reservs);
    });

    $scope.accept= function(reserv){
        $scope.reservs.pop(reserv);
        reserv.$update();
    } ;
    $scope.cancel= function(reserv){
        reserv.$update();
    } ;
    $scope.dataTransform=function(data){
        var date = new Date(data);
        var dateToStr = date.toUTCString().split(' ');
        var cleanDate = dateToStr[1] + ' ' + dateToStr[2] + ' ' + dateToStr[3] ;
        return cleanDate;
    };

});