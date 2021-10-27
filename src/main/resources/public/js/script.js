var testApp = angular.module("testApp", []);

testApp.controller("testController", function($scope, $http, $window, $interval) {
    $scope.result = [];
    $scope.cube_id = null;
    $scope.amountIn = 1;
    $scope.amountOut = 1;
    $scope.rateIn = 0;
    $scope.rateOut = 0;
    $scope.currencyIndexIn = null;
    $scope.currencyIndexOut = null;
    $window.onload = function() {
        $http.get("http://localhost:8080/cubes/").then(
            function (response) {
                $scope.cube_id = response.data["id"];
                for(var i in response.data["currencyList"])
                {
                    $scope.result.push({
                        title:response.data["currencyList"][i].title,
                        rate:response.data["currencyList"][i].rate
                    });
                }
            },
            function errorCallback(response) {
                console.log("Unable to perform get request");
            }
        );
        $scope.showdeals();
    };

    $scope.changeIn = function(){

        try {
            let find = $scope.result.find(obj => {
                return obj.title === $scope.currencyIndexIn
            })
            $scope.rateIn = find.rate;
            console.log("IN: "+$scope.currencyIndexIn+" "+$scope.rateIn)
        }
        catch (e) {
            console.log("IN: "+$scope.currencyIndexIn)
        }
    };
    $scope.changeOut = function(){
        try {
            let find = $scope.result.find(obj => {
                return obj.title === $scope.currencyIndexOut
            })
            $scope.rateOut = find.rate;
            console.log("OUT: "+$scope.currencyIndexOut+" "+$scope.rateOut)
        }
        catch (e) {
            console.log("OUT: "+$scope.currencyIndexOut)
        }
    };
    $scope.convert = function () {
        $scope.amountOut = parseFloat($scope.amountIn * $scope.rateOut / $scope.rateIn).toFixed(3);
        let parameter = ({date:"2021-10-25", username:"Anton",
            incurr:$scope.currencyIndexIn, outcurr:$scope.currencyIndexOut, amount:$scope.amountIn, cubed:{id:($scope.cube_id).toString()}});
        console.log(parameter)
        $http.post("http://localhost:8080/deal/", parameter).
        success(function(data, status, headers, config) {
            // this callback will be called asynchronously
            // when the response is available
            // console.log(data);
        }).
        error(function(data, status, headers, config) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });

    }

    $scope.showdeals = function(){
        $http.get("http://localhost:8080/deal/all")
            .then(function (response) {
                // console.log(response.data)
                $scope.deals = response.data;});
    }


    $scope.$watch('currencyIndexIn',function(){ $scope.changeIn(); });
    $scope.$watch('currencyIndexOut',function(){ $scope.changeOut(); });

    $interval(function() {
        $scope.showdeals();
    }, 2000)
});