/**
 * Created by Администратор on 23.02.2016.
 */
var application = angular.module('appp', ['ngResource']);
application.controller("userController",function($scope, $resource) {
    var Users  = $resource('/api/user/filter/residents');
    var users = Users.query(function() {
        $scope.users=users;
    });

    $scope.usersNow=function(){
        var Users  = $resource('/api/user/filter/residents');
        var users = Users.query(function() {
            $scope.users=users;
        });
    }
    $scope.usersLastYear=function(){
        var Users  = $resource('/api/user/filter/terminated');
        var users = Users.query(function() {
            $scope.users=users;
        });
    }
});