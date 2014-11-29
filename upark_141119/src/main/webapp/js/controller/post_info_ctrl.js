function postInfoCtrl($scope,$resource,$location,Greeting){
	if(Greeting.greet.isLogIn == false){
		$location.path("/");
	}
	else
		$scope.username = Greeting.greet.text;
	
}