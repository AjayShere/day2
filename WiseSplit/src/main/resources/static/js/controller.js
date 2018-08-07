var app = angular.module('app', [ 'ngRoute' ]).config(function($routeProvider) {
	$routeProvider.when("/login", {

		templateUrl : "templates/login.html",
		controller : 'loginController'
	}).when("/createUser", {

		templateUrl : "templates/user.html",
		controller : 'postcontroller'
	}).when("/addMoney", {

		templateUrl : "templates/addMoney.html",
		controller : 'addAmountController'
	})
	/*
	 * .otherwise({ templateUrl:"templates/login.html", controller :
	 * 'loginController' })
	 */
}).controller('addAmountController', function($scope, $http, $location) {

	$scope.AddAmount = function(userId) {

		var url = "http://localhost:8080/v1/addMoney";

		var data = {
			comment : $scope.comment,
			amount : $scope.amount,
			userId : userId

		};

		$http.post(url, data).then(function(response) {
			$scope.postResultMessage = response;
		}, function error(response) {
			$scope.postResultMessage = "Error with status: " +response;
		});

		$scope.comment = "";
		$scope.amount = "";

	};

}).controller(
		'postcontroller',
		function($scope, $http, $location) {

			$scope.submitForm = function() {

				var url = "http://localhost:8080/v1/createUser";

				var data = {
					firstname : $scope.firstname,
					lastname : $scope.lastname,
					emailId : $scope.emailID

				};

				data = angular.toJson(data);

				$http.post(url, data).then(
						function(response) {
							$scope.postResultMessage = response;
						},
						function error(response) {
							$scope.postResultMessage = "Error with status: "
									+response.emailId;
						});

				$scope.firstname = "";
				$scope.lastname = "";
				$scope.emailid = "";

			}

		}).controller('loginController', function($scope) {

	$scope.message = "loginLogin";
	$scope.submit = function($scope, $password) {
		var uname = $scope.username;
		var pass = $scope.password;

		if ($scope.username == "Admin" && $scope.password == "Admin") {
			$location.path('/dashboard');
		}

	}

});

/*
 * app.config(['$routeProvider', function($routeProvider){
 * 
 * $routeProvider .when('/login',{ templateUrl : 'login.html', controller
 * :'loginController' })
 * 
 * .when('/dashboard',{ templateUrl : 'user.html', controller : 'postcontroller' })
 * .otherwise({ templateUrl : '/' });
 * 
 * }]);
 */

