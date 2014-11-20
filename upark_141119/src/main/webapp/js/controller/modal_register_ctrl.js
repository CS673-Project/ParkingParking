app.controller('modalRegisterCtrl',function($scope,$resource,$location,Greeting){
	var User = $resource(
                    '/upark/reg'
                );
    $scope.registerConfirm = function(){
        var user = User.save(
                        {
                            username:$scope.input_username,
                            password:$scope.input_password,
                           	repassword:$scope.input_re_password,
                            firstname:$scope.input_first_name,
                            lastname:$scope.input_last_name
                        },
                        function()
                            {
                                if(user.username != "" ){
                                   // $scope.$parent.account.text = user.username;
                                   Greeting.greet.text = user.username;
                                   Greeting.greet.isLogIn = true; 
                                   $('#modal-register').modal('hide');
                                }
                                else{
                                   alert("This username is registered, please choose another one");
                                }
                                
                            }
                        );

    }
});