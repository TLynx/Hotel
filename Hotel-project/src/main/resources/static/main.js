/**
 * Created by Администратор on 23.02.2016.
 */
var application = angular.module('appp', ['ngResource']);
application.filter('unique', function() {
    return function(collection, keyname) {
        var output = [],
            keys = [];

        angular.forEach(collection, function(item) {
            var key = item[keyname];
            if(keys.indexOf(key) === -1) {
                keys.push(key);
                output.push(item);
            }
        });

        return output;
    };
});

application.controller("mainController",function($scope, $resource) {
    var Room  = $resource('/api/room');
    var Reserv  = $resource('/api/reserve');
    var rooms = Room.query(function(){
        $scope.rooms =  rooms;
    });
    $scope.selectDate=function(){
        console.log($scope.res.checkIn+" - "+$scope.res.checkOut);
    }

    $scope.selectRoom=function(room){
        $scope.res.room=room;
    }
    $scope.reserve=function(){
        Reserv.save($scope.res);
    }

});

