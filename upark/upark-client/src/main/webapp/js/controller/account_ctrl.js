// angularJS navCtrl implementation for nav
app.controller("accountCtrl",function($scope,$http,$location){
  
    
    var user={
    	username:"",
    	password:"",
    };
    var account_status = false;
    $scope.account = {
        text:"Sign in",
        input_username:"",
    };
    
    $scope.signIn = function(){
    	if(account_status == false)
        	$("#modal-sign-in").modal().css({'margin-top': function(){return ($(this).height()/2-120);}});
        else
        	$location.url("/view/"+user.username);
    };

    $scope.logIn = function(){
    	$http.get('data/account.json').success(function(data) {
    		
   		user = data;
   		if($scope.account.input_username == user.username ){
   	   		$scope.account.text = user.username ;
   	   		account_status = true;
   	   		
   	   		
   	   	}
	});
    }
	

});
