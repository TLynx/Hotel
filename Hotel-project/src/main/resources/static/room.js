
var application = angular.module('app', ['ngResource']);

application.controller("RoomController",function($scope, $resource) {
    var Room  = $resource('/api/room');
    var rooms = Room.query(function(){
        $scope.rooms =  rooms;
    });
    $scope.roomTypes={
        "Single standart":"SINGLE_STANDARD",
        "Single moderate":"SINGLE_MODERATE",
        "Single delux":"SINGLE_DELUXE",
        "Double standart":"DOUBLE_STANDARD",
        "Double moderate":"DOUBLE_MODERATE",
        "Double delux":"DOUBLE_DELUXE",
        "Triple standart":"TRIPLE_STANDARD",
        "Triple moderate":"TRIPLE_MODERATE",
        "Triple delux":"TRIPLE_DELUXE",
        "Quad standart":"QUAD_STANDARD",
        "Quad delux":"QUAD_DELUXE"
    };
    $scope.roomNiceTypes=[
        "Single standart",
        "Single moderate",
        "Single delux",
        "Double standart",
        "Double moderate",
        "Double delux",
        "Triple standart",
        "Triple moderate",
        "Triple delux",
        "Quad standart",
        "Quad delux"
    ];

   $scope.update= function(room){
      room.$save();
    } ;

    $scope.add=function(roo){
        roo.type=$scope.roomTypes[roo.type];
        $scope.rooms.push(roo);
        Room.save(roo);
    } ;



    $scope.all=function(){
        var Room  = $resource('/api/room');
        var rooms = Room.query(function(){
            $scope.rooms =  rooms;
        });
    };
    $scope.free=function(){
        var Room  = $resource('/api/room/free');
        var rooms = Room.query(function(){
            $scope.rooms =  rooms;
        });
    };
    $scope.soon=function(){
        var Room  = $resource('/api/room/releasedSoon');
        var rooms = Room.query(function(){
            $scope.rooms =  rooms;
        });
    };









});



