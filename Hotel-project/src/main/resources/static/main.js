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
    var Reserv  = $resource('/api/reservation');
    $scope.selectDate=function(){
        var Rooms=$resource('/api/room/all?checkIn='+$scope.res.checkIn+'&checkOut='+$scope.res.checkOut);
        var rooms = Rooms.query(function() {
            $scope.rooms=rooms;
        });
        var oneDay = 24*60*60*1000; // hours*minutes*seconds*milliseconds
        var firstDate = new Date($scope.res.checkIn);
        var secondDate = new Date($scope.res.checkOut);

       $scope.diffDays = Math.round(Math.abs((firstDate.getTime() - secondDate.getTime())/(oneDay)));

    }

    $scope.selectRoom=function(room){
        $scope.res.totalPrice=  $scope.diffDays*room.price;
        $scope.res.room=room;
    }
    $scope.reserve=function(){
        console.log($scope.res);

        Reserv.save($scope.res);
    }

});

