/**
 * Created by Администратор on 23.02.2016.
 */
var application = angular.module('appp', ['ngResource']);
application.controller("userController",function($scope, $resource) {
    var Users  = $resource('/api/user');
    var users = Users.query(function() {
        $scope.users=users;
    });


});