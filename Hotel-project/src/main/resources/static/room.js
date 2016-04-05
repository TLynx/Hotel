
var application = angular.module('app', ['ngResource']);

application.controller("RoomController",function($scope, $resource) {
    var Room  = $resource('/api/room');
    var Type = $resource('/api/room');
    var rooms = Room.query(function(){
        $scope.rooms =  rooms;
    });
    var types = Type.query(function(){
        $scope.types =  types;
    });

   $scope.update= function(room){
      room.$save();
    }

    $scope.add=function(){
        console.log($scope.roo);
        $scope.rooms.push($scope.roo);
        Room.save($scope.roo);
    }



});



