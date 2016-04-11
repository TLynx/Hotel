/**
 * Created by Администратор on 23.02.2016.
 */
var application = angular.module('appp', ['ngResource']);
application.controller("userController",function($scope, $resource) {
    var Reservs  = $resource('/api/reservation/active');
    var reservs = Reservs.query(function() {
        $scope.reservs=reservs;
    });

    $scope.usersNow=function(){
        var Reservs  = $resource('/api/reservation/active');
        var reservs = Reservs.query(function() {
            $scope.reservs=reservs;
        });
    }
    $scope.usersLastYear=function(){
        var Users  = $resource('/api/user/filter/terminated');
        var users = Users.query(function() {
            $scope.users=users;
        });
    }
    $scope.dataTransform=function(data){
        var date = new Date(data);
        var dateToStr = date.toUTCString().split(' ');
        var cleanDate = dateToStr[1] + ' ' + dateToStr[2] + ' ' + dateToStr[3] ;
        return cleanDate;
    };
});