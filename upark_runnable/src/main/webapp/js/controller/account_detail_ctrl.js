function accountDetailCtrl($scope, $resource,$location, $routeParams) {
	$scope.user = {username: ''};
    

    var User = $resource(
                    'php/test3.php/username/:username/',
                    {
                        username:''
                    }
                );

    var user = User.save(
    			{
    				username:$routeParams.username
    			},
    			function(){
    				
    				if(user.username == ""){

    					$location.path("/");
    					
    				}
    				else
    					$scope.user.username = user.username;
				}
			);

}