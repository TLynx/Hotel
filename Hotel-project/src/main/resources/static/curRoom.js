/**
 * Created by ihor on 06.04.2016.
 */
var application = angular.module('app', ['ngResource']);

application.controller("RoomController",function($scope, $resource) {
    var Room = $resource('/api/room', {}, {update: {method: "PUT"}});
    var rooms = Room.query(function () {
        $scope.rooms = rooms;
    });

    $scope.update= function(room){
        room.$update();
    } ;

});
