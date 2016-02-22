
function Hello($scope, $http) {


    //invoked on <script  load time
    $http.get('greeting', {data: {name: name}}).
        success(function(data) {
            $scope.greeting = data;
        });



    $scope.update = function() {
        $http.get('greeting', {params: {name: $scope.name}}).
            success(function(data) {
                $scope.greeting = data;
            });
        console.log($scope.one);
    }

}

angular.module('app', []).controller('Hello', Hello);