// angularJS navCtrl implementation for nav
app.controller('topNavCtrl', function($scope,$location,$resource,Greeting){
    
    var User = $resource('php/test.php');

    $scope.greeting = Greeting.greet;

    var user = User.get({},function(response){
      if(user.username !=""){
        $scope.greeting.text = user.username;
        Greeting.greet.isLogIn = true;
      }
    });

    
    $scope.signIn = function(){
    	if($scope.greeting.isLogIn == false)
        	$("#modal-sign-in").modal().css({'margin-top': function(){return ($(this).height()/2-120);}});
      else{
       	  $location.path("/account/"+$scope.greeting.text);
          
        }
    };

   // $scope.$watch('Greeting',function(){$scope.account.text = Greeting.greet;})
	

});
