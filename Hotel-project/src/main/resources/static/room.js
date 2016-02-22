
var application = angular.module('app', ['ngResource']);

application.controller("RoomController",function($scope, $resource) {
    var Room  = $resource('/api/room');
    var rooms = Room.query(function(){
        $scope.rooms =  rooms;
    });

});



