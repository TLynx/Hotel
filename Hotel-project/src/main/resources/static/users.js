/**
 * Created by Администратор on 23.02.2016.
 */
var application = angular.module('appp', ['ngResource']);
application.controller("userController",function($scope, $resource) {
    var Reservs  = $resource('/api/reservation/active',{},{remove : {method:"PATCH"}});
    var reservs = Reservs.query(function() {
        $scope.reservs=reservs;
    });

    $scope.usersNow=function(){
        var Reservs  = $resource('/api/reservation/active');
        var reservs = Reservs.query(function() {
            $scope.reservs=reservs;
        });
    }

    $scope.remove=function(reserv){
        var RemoveUser  = $resource('/api/room/'+reserv.room.id,{},{remove: {method :"PATCH"}});
        $scope.reservs.splice($scope.reservs.indexOf(reserv),1);
        RemoveUser.remove();
    }



    $scope.dataTransform=function(data){
        var date = new Date(data);
        var dateToStr = date.toUTCString().split(' ');
        var cleanDate = dateToStr[1] + ' ' + dateToStr[2] + ' ' + dateToStr[3] ;
        return cleanDate;
    };


});