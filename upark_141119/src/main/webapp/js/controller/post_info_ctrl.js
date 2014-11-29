app.controller( 'postInfoCtrl',function($scope,$resource,$location,Greeting){
	if(Greeting.greet.isLogIn == false){
		$location.path("/");
	}
	else{
		$scope.username = Greeting.greet.text;
		$scope.email = Greeting.greet.email;
	}
	
	
	$scope.postInfo = function(){
		alert($scope.zipcode);
		alert($scope.address1);
		var postInfo = $resource(
				'/upark/post' 
				);
		
		var info = postInfo.save(
    			{
    				area: $scope.area,
    				zipcode: $scope.zipcode,
    				address1: $scope.address1,
    				address2: $scope.address2,
    				date: $scope.date,
    				startTime: $scope.startTime,
    				endTime: $scope.endTime,
    				unitPirce: $scope.price
    			},
    			function(){
    				
    				if(1){

    					$location.path("/");
    					
    				}
    				else{
    					
                    }
				}
		);
	}
	
})