
var application = angular.module('app', ['ngResource']);

application.controller("RoomController",function($scope, $resource) {
    var Room  = $resource('/api/room');
    var rooms = Room.query(function(){
        $scope.rooms =  rooms;
    });
   $scope.update= function(room){
      room.$save();
    } ;

    $scope.add=function(){
        console.log($scope.roo);
        $scope.rooms.push($scope.roo);
        Room.save($scope.roo);
    } ;

    $scope.roomTypes={
        "Одномісний стандарт":"SINGLE_STANDARD",
        "Одномісний покращений":"SINGLE_MODERATE",
        "Одномісний люкс":"SINGLE_DELUXE",
        "Двомісний стандарт":"DOUBLE_STANDARD",
        "Двомісний покращений":"DOUBLE_MODERATE",
        "Двомісний люкс":"DOUBLE_DELUXE",
        "Трьохмісний стандарт":"TRIPLE_STANDARD",
        "Трьохмісний покращений":"TRIPLE_MODERATE",
        "Трьохмісний люкс":"TRIPLE_DELUXE",
        "Чотирьохмісний стандарт":"QUAD_STANDARD",
        "Чотирьохмісний люкс":"QUAD_DELUXE"
    };
    $scope.roomNiceTypes=[
        "Одномісний стандарт",
        "Одномісний покращений",
        "Одномісний люкс",
        "Двомісний стандарт",
        "Двомісний покращений",
        "Двомісний люкс",
        "Трьохмісний стандарт",
        "Трьохмісний покращений",
        "Трьохмісний люкс",
        "Чотирьохмісний стандарт",
        "Чотирьохмісний люкс"
    ];





});



