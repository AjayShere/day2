var app = angular.module('app' ,['ngRoute']);

app.config(['$routeProvider', function($routeProvider){
	
	$routeProvider
	.when('/login',{
		templateUrl : 'login.html',
		controller :'loginController'
	})
	
	.when('/dashboard',{
		templateUrl : 'user.html',
			controller : 'postcontroller'
			 
	})
	.otherwise({
		templateUrl : '/'
	});
	
}]);




app.controller('postcontroller',function($scope,$http,$location){
	
	$scope.submitForm = function(){
		
		var url = $location.absUrl() + "createUser";
		
		var data = {
				firstname: $scope.firstname,
	            lastname: $scope.lastname,
	            emailId : $scope.emailID
						
		};
		
		$http.post(url , data).then(function(response){
			$scope.postResultMessage =response.emailId
		},function error(response){
			$scope.postResultMessage = "Error with status: " +  response.emailId;
		});
		
		$scope.firstname ="";
        $scope.lastname="";
        $scope.emailid="";
		
		}
		
	});


app.controller('loginController', function($scope){
	
	$scope.submit =function($scope ,$password){
		var uname = $scope.username;
		var pass =$scope.password;
		
	if($scope.username == "Admin"  && $scope.password=="Admin"){
		$location.path('/dashboard');
	}
		
	};
	
});



