function accountDetailCtrl($scope, $resource,$location, $routeParams) {
	$scope.user = {username: ''};
    

    var User = $resource(
                    '/upark/checkSession'  
                );

    var user = User.save(
    			{
    				username:$routeParams.username
    			},
    			function(){
    				
    				if(user.username == ""){

    					$location.path("/");
    					
    				}
    				else{
    					$scope.user.username = user.username;
                        $scope.user.lastname = user.lastname;
                        $scope.user.firstname = user.firstname;
                    }
				}
			);
    $scope.postInfo = function(){
    	$location.path("/postInfo");
    }

}